package compliation;

import java.util.Scanner;

/**
 * 递归下降
 * Created by parting_soul on 17-4-12.
 * <p>
 * S->AaS
 * S->BbS
 * S->d
 * A->a
 * B->^
 * B->c
 * <p>
 * select(S->AaS) = {a}
 * select(S->BbS) = {b,c}
 * select(S->d) = {d}
 * select(A->a) = {a}
 * select(B->^) = {b}
 * select(B->c) = {c}
 */
public class LL1Analyze {

    private String textContent;
    private int currentPos;
    private ErrorException exception;

    public LL1Analyze() {
        exception = new ErrorException("语法错误");
    }

    public static void main(String[] args) {
        LL1Analyze analyze = new LL1Analyze();
        Scanner in = new Scanner(System.in);
        String str = null;
        System.out.println("输入待匹配串:");
        while ((str = in.nextLine()) != null) {
            analyze.setTextContent(str);
            try {
                analyze.start();
            } catch (ErrorException e) {
                System.out.println(e.getMessage());
            }
            analyze.init();
            str = null;
            System.out.println("输入待匹配串:");
        }
    }

    public void init() {
        currentPos = 0;
        textContent = null;
    }

    /**
     * 从开始符开始匹配
     */
    private void start() throws ErrorException {
        parseStart();
        if (currentPos < textContent.length()) {
            //若未匹配完全,则也为语法错误
            throw exception;
        }
        System.out.println("语法分析正确");
    }

    private void error() throws ErrorException {
        throw exception;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    /**
     * 匹配终结符
     *
     * @param pattern
     */
    public void matchTerminal(char pattern) throws ErrorException {
        if (currentPos >= textContent.length()) throw exception;
        char currentC = textContent.charAt(currentPos);
        if (currentC != pattern) {
            error();
        } else {
            currentPos++;
        }
    }

    private void parseStart() throws ErrorException {
        if (currentPos >= textContent.length()) throw exception;
        char currentC = textContent.charAt(currentPos);
        switch (currentC) {
            case 'a':
                //select(S->AaS)
                parseA();
                matchTerminal('a');
                parseStart();
                break;
            case 'b':
            case 'c':
                //select(S->BbS);
                parseB();
                matchTerminal('b');
                parseStart();
                break;
            case 'd':
                //select(S->d)
                matchTerminal('d');
                break;
            default:
                error();
                break;
        }
    }

    public void parseA() throws ErrorException {
        if (currentPos >= textContent.length()) throw exception;
        char currentC = textContent.charAt(currentPos);
        switch (currentC) {
            case 'a':
                //select(A->a)
                matchTerminal('a');
                break;
            default:
                error();
                break;
        }
    }

    public void parseB() throws ErrorException {
        if (currentPos >= textContent.length()) throw exception;
        char currentC = textContent.charAt(currentPos);
        switch (currentC) {
            case 'b':
                //select(B->^)
                break;
            case 'c':
                //select(B->c)
                matchTerminal('b');
                break;
            default:
                error();
                break;
        }
    }
}

class ErrorException extends Exception {

    public ErrorException(String msg) {
        super(msg);
    }

}