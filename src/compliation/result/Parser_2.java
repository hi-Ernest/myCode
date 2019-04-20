package compliation.result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author chr
 * @Date 4/17/2019 10:39 PM
 * @Version 2.0
 */
public class Parser_2 {

    //+-*/i的集合
    private Map map;

    //存储字符串(符号和变量等)
    private List<String> list;

    //列表的下标
    private int index = 0;

    //每次扫描的字符串
    private String token;

    //最终的结果
    private boolean flag = true;

    public Parser_2(List inputList) {
        map = new HashMap();

        map.put(1, "+");
        map.put(2, "-");
        map.put(3, "*");
        map.put(4, "/");
        map.put(5, "(");
        map.put(6, ")");
        map.put(7, "i");

        Map map2 = new HashMap();
        map2.putAll(map);
        map2.remove(7);

        this.list = inputList;
        for(int i=0;i<list.size();i++){
            if(!map2.containsValue(list.get(i)))
                list.set(i, "i");
        }
        System.out.println(list);
        this.token = list.get(index);
    }


    //首先读入的字符
    /**
     * E1:+
     * E2:-
     * T1:*
     * T2:/
     */
    public boolean E() {
        T();
        E1();

        return flag;
    }

    public void T() {
        A();
        E2();
    }

    public void A() {
        B();
        T2();
    }

    public void B() {
        F();
        T1();
    }


    //重复调用判断后面紧跟的是否是(->)
    //i
    public void F() {

        if(token.equals("(")){
            match("(");
            E();
            if(token.equals(")"))
                match(")");
            else
                error();
        }
        else if(token.equals("i"))
            match("i");
        else
            error();
    }

    public void E1() {
        if(token.equals("+")) {
            token = "";
            match("+");
            T();
            E1();
        }
    }

    public void E2() {
        if(token.equals("-")) {
            token = "";
            match("-");
            A();
            E2();
        }
    }

    public void T1() {
        if(token.equals("*")) {
            match("*");
            F();
            T1();
        }
    }

    public void T2() {
        if(token.equals("/")) {
            match("/");
            B();
            T2();
        }
    }

    public boolean match(String input) {
        if(index+1 < list.size()) {
            if(map.containsValue(input))
                token = getNextToken();
            return true;
        }else
            return false;

    }

    private String getNextToken() {
        index++;
        return list.get(index);
    }

    //输出错误信息
    private void error() {
        System.out.println("错误表达式");
        this.flag = false;
    }



    public static void main(String[] args) throws IOException {

        //接收的算数表达式
        String expr;
        //Scanner or BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入一个空的字符串则退出.....");

        //一直输入直到输入为空结束
        while (true){
            System.out.print("请输入您的算数表达式: ");
            expr = br.readLine();
            if ("".equals(expr)) {
                break;
            }

            SplitIdentifier_1 splitIdentifier_1 = new SplitIdentifier_1();
            List list = splitIdentifier_1.recognizeId(expr);
            Parser_2 p = new Parser_2(list);

            if(p.E())
                System.out.println("您输入的表达式正确！！");
        }
    }

}
