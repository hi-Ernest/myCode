package compliation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author chr
 * @Date 4/15/2019 12:33 PM
 * @Version 1.0
 */
public class Parser {
    //These are the token types 标识符类型常量
    /**
     * 未定义的标识符
     */
    final int NONE = 0;
    /**
     * 分隔符(包括运算符和括号)
     */
    final int DELIMITER = 1;
    /**
     * 变量
     */
    final int VARIABLE = 2;
    /**
     * 数值
     */
    final int NUMBER = 3;

    //These are the types of the syntax errors 语法错误类型常量
    /**
     * 所有导致非正则表达式的错误
     */
    final int SYNTAX = 0;
    /**
     * 括号不对称错误
     */
    final int UNBALPARENS = 1;
    /**
     * 没有表达式
     */
    final int NOEXP = 2;
    /**
     * 除数为0
     */
    final int DIVBYZERO = 3;

    /**
     * This token indicates end-of-expression 表达式结束标识符
     * 标志解析器已达到表达式结尾
     */
    final String EOE = "\0";

    /**
     * refers to expression string 表达式字符串
     */
    private String exp;
    /**
     * current index into the expression 表达式中当前标识符的索引
     */
    private int expIdx;
    /**
     * holds current token 当前标识符
     */
    private String token;
    /**
     * holds token's type 标识符类型
     */
    private int tokType;

    /**
     * Array for variables 变量数组
     */
    private double vars[] = new double[26];

    /**
     * Parser entry point 解析器入口
     *
     * @param expstr 表达式字符串
     * @return 表达式的值
     * @throws ParserException
     */
    public double evaluate(String expstr) throws ParserException {
        double result;
        exp = expstr;
        expIdx = 0;

        //获取下一个字符
        getToken();
        if (token.equals(EOE)) {
            handleErr(NOEXP);//no expression present
        }

        //Parse and evaluate the expression
        result = assignment();

        if (!token.equals(EOE)) {//last token must be EOE
            handleErr(SYNTAX);
        }

        return result;
    }


//    public String isExp(String expstr) throws ParserException {
//        String result;
//        exp = expstr;
//        expIdx = 0;
//
//        //获取下一个字符
//        getToken();
//        if (token.equals(EOE)) {
//            handleErr(NOEXP);//no expression present
//        }

        //Parse and evaluate the expression
//        result = "是一个正确的表达式";

//        if (!token.equals(EOE)) {//last token must be EOE
//            handleErr(SYNTAX);
//        }

//        return result;
//    }

    /**
     * Process an assignment 处理赋值语句
     *
     * @return
     * @throws ParserException
     */
    private double assignment() throws ParserException {
        double result;
        int varIdx;
        int ttokType;
        String temptoken;

        if (tokType == VARIABLE) {
            //save old token
            temptoken = new String(token);
            ttokType = tokType;

            //Compute the index of a variable.
            varIdx = Character.toUpperCase(token.charAt(0)) - 'A';

            getToken();
            if (!token.equals("=")) {
                putBack();//return current token
                //restore old token -- not an assignment
                token = new String(temptoken);
                tokType = ttokType;
            } else {
                getToken();
                result = addOrSubtract();
                vars[varIdx] = result;
                return result;
            }
        }

        return addOrSubtract();
    }

    /**
     * Add or subtract two terms. 两个数值加或减
     *
     * @return
     * @throws ParserException
     */
    private double addOrSubtract() throws ParserException {
        char op;
        double result;
        double partialResult;

        result = multiplyOrDivide();

        while ((op = token.charAt(0)) == '+' || op == '-') {
            getToken();
            partialResult = multiplyOrDivide();
            switch (op) {
                case '-':
                    result = result - partialResult;
                    break;
                case '+':
                    result = result + partialResult;
                    break;
            }
        }

        return result;
    }

    /**
     * Multiply or divide two factors. 两个数值乘、除或取模
     *
     * @return
     * @throws ParserException
     */
    private double multiplyOrDivide() throws ParserException {
        char op;
        double result;
        double partialResult;

        result = exponent();

        while ((op = token.charAt(0)) == '*' || op == '/' || op == '%') {
            getToken();
            partialResult = exponent();
            switch (op) {
                case '*':
                    result = result * partialResult;
                    break;
                case '/':
                    if (partialResult == 0.0) {
                        handleErr(DIVBYZERO);
                    }
                    result = result / partialResult;
                    break;
                case '%':
                    if (partialResult == 0.0) {
                        handleErr(DIVBYZERO);
                    }
                    result = result % partialResult;
                    break;
            }
        }

        return result;
    }

    /**
     * Process an exponent. 指数运算
     *
     * @return
     * @throws ParserException
     */
    private double exponent() throws ParserException {
        double result;
        double partialResult;
        double ex;
        int t;

        result = unary();

        if (token.equals("^")) {
            getToken();
            partialResult = exponent();
            ex = result;
            if (partialResult == 0.0) {
                result = 1.0;
            } else {
                for (t = (int) partialResult - 1; t > 0; t--) {
                    result = result * ex;
                }
            }
        }

        return result;
    }

    /**
     * Evaluate a unary + or -. 一元取正或一元取负运算
     *
     * @return
     * @throws ParserException
     */
    private double unary() throws ParserException {
        double result;
        String op = "";
        //检查标识符是否为一元取正或一元取负运算符
        if (tokType == DELIMITER && token.equals("+") || token.equals("-")) {
            op = token;
            getToken();
        }

        result = parenthesize();

        if (op.equals("-")) {
            result = -result;
        }

        return result;
    }

    /**
     * Process a parenthesized expression. 处理括号表达式
     *
     * @return
     * @throws ParserException
     */
    private double parenthesize() throws ParserException {
        double result;
        //如果读取的是括号时递归调用addOrSubtract()
        if (token.equals("(")) {
            getToken();
            result = addOrSubtract();
            if (!token.equals(")")) {
                handleErr(UNBALPARENS);
            }
            getToken();
        } else {
            result = atom();
        }

        return result;
    }

    /**
     * Get the value of a number or variable. 获取一个数值字符串或变量的值
     *
     * @return
     * @throws ParserException
     */
    private double atom() throws ParserException {
        double result = 0.0;

        switch (tokType) {
            case NUMBER:
                try {
                    result = Double.parseDouble(token);
                } catch (NumberFormatException e) {
                    handleErr(SYNTAX);
                    e.printStackTrace();
                }
                getToken();
                break;
            case VARIABLE:
                result = findVar(token);
                getToken();
                break;
            default:
                handleErr(SYNTAX);
                break;
        }
        return result;
    }

    /**
     * Return the value of a variable. 获取变量的值
     *
     * @param vname
     * @return
     * @throws ParserException
     */
    private double findVar(String vname) throws ParserException {
        if (!Character.isLetter(vname.charAt(0))) {
            handleErr(SYNTAX);
            return 0.0;
        }
        return vars[Character.toUpperCase(vname.charAt(0)) - 'A'];
    }

    /**
     * Return a token to the input stream.
     * 当标识为'='时，返回到标识符之前的索引位置
     */
    private void putBack() {
        if (token == EOE) {
            return;
        }
        for (int i = 0; i < token.length(); i++) {
            expIdx--;
        }
    }

    /**
     * Handle an error. 错误处理
     *
     * @param error
     * @throws ParserException
     */
    private void handleErr(int error) throws ParserException {
        String[] err = {
                "表达式不存在",
                "表达式不规范",
                "除数为0"
        };
        throw new ParserException(err[error]);
    }

    /**
     * 获得表达式中的下一个标识符
     */
    private void getToken() {
        tokType = NONE;
        token = "";

        //检查索引是否到达表达式结束位置
        if (expIdx == exp.length()) {
            token = EOE;
            return;
        }

        //跳过空格
        while (expIdx < exp.length() && Character.isWhitespace(exp.charAt(expIdx))) {
            ++expIdx;
        }

        //Trailing whitespace ends expression
        if (expIdx == exp.length()) {
            token = EOE;
            return;
        }

        if (isDelim(exp.charAt(expIdx))) {//是否是分隔符(运算符)
            token += exp.charAt(expIdx);
            expIdx++;
            tokType = DELIMITER;
        } else if (Character.isLetter(exp.charAt(expIdx))) {//是否是一个变量(字母)
            //不是分隔符则进入循环并++
            while (!isDelim(exp.charAt(expIdx))) {
                token += exp.charAt(expIdx);
                expIdx++;
                if (expIdx >= exp.length()) {
                    break;
                }
            }
            tokType = VARIABLE;
        } else if (Character.isDigit(exp.charAt(expIdx))) {//是否是一个数字
            while (!isDelim(exp.charAt(expIdx))) {
                token += exp.charAt(expIdx);
                expIdx++;
                if (expIdx >= exp.length()) {
                    break;
                }
            }
            tokType = NUMBER;
        } else {
            token = EOE;
            return;
        }

    }

    /**
     * Return true if c is a delimiter. 判断是不是一个分隔符
     */
    private boolean isDelim(char c) {
        if (" +-*/%^=()".indexOf(c) != -1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        //接收的算数表达式
        String expr;

        Double result = 0.0;

        //Scanner or BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Parser p = new Parser();

        System.out.println("Enter an empty expression to stop.");

        //一直输入直到输入为空结束
        for(;;){
            System.out.print("Enter expression: ");
            expr = br.readLine();
            if("".equals(expr)){
                break;
            }
            try {
                result = p.evaluate(expr);
//                System.out.println("Result: " + result);
                System.out.println("表达式成立");
                System.out.println();

            } catch (ParserException e) {
                System.out.println(e);
            }
        }
    }
}
