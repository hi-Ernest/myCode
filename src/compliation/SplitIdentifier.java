package compliation;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

/**
 * a+e+67/9*
 *
 * char[] c = {'+' ,'-', '*', '/', '(', ')'};
 * 扫描
 */
public class SplitIdentifier {

    //指针扫描到的位置
    private static int tracking  = 0;

    //字符变量(最新读入的字符)
    private char ch;

    private static String str = "int+89898+5566 gge323f*";

    public static void main(String []args) {
        SplitIdentifier splitIdentifier = new SplitIdentifier();
        List<String> list = splitIdentifier.recognizeId();

        for(int i=0 ;i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public List recognizeId() {

        List<String> list = new ArrayList<>();

        //一开始先设置状态(对之下的判断条件的进入)
        char state = '0';

        //满足while条件则进入
        while (tracking < str.length()) {
            getNextChar();
//            getBc();

            while(state != '2') {
                switch (state) {
                    //条件是字母的情况
                    case '0': if(Character.isLetter(ch)) {
                        System.out.print(ch);
                        getNextChar();
                        state = '1';
                        break;
                    //扫描到空格则略过
                    } else if(Character.isSpaceChar(ch)) {
                        getNextChar();
                        state = '0';
                        break;
                    //第一个是数字(判断该第一个字符之后的字符是否都是数字-->直到空格或者字符串结束)
                    } else if(Character.isDigit(ch)) {
                        int start = tracking;
                        if(isNumbers()) {
                            System.out.println(str.substring(start-1, tracking));

                            list.add(str.substring(start-1, tracking));
                            state = '0';
                            break;
                        }
                        //不是(如:5632Good)则
                        else {
                            //输入不符合规范
                            error();

                            //字符一直读入然后到空格接受第一个字符则进入state='0'
                            if (getPosition()) {
                                getNextChar();
                                state = '0';
                            }else
                                state = '2';
                            break;
                        }
                    }
                    //第一个字符既不是字母也不是数字-->则显示错误信息并略过
                    else {
                        //输入不符合规范
                        error();

                        //字符一直读入然后到空格接受第一个字符则进入state='0'
                        if (getPosition()) {
                            getNextChar();
                            state = '0';
                        }else
                            state = '2';
                        break;
                    }

                    case '1': if(Character.isLetter(ch)||Character.isDigit(ch)) {
                                state = '1';
                                System.out.print(ch);

                                list.add(ch+"");
                                getNextChar();
                              } else if(Character.isSpaceChar(ch)) {
                                    System.out.println();
                                    getNextChar();
                                    state = '0';
                                    break;
                              }
                              else
                                  state = '2';
                                  break;
                    case '3':
                }
            }
        }
        return list;
    }

    /**
     * 接受下一个字符
     * @return
     */
    public void getNextChar() {
        ch = str.charAt(tracking);
        tracking++;
    }

    /**
     * 检查读入的字符是否空白
     * 是的话就调用getNextChar,直到下一个字符不是
     */
    public void getBc() {
        while (Character.isSpaceChar(ch))
            getNextChar();
    }

    /**
     * 针对报错没有考虑的情况
     */
    public static void error() {
        System.out.println("出现错误");
    }

    public boolean getPosition() {
        int count = tracking;
        while(count++ < str.length()) {
            getNextChar();
            if(Character.isSpaceChar(ch)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 针对识别数字的问题
     */
    public boolean isNumbers() {
        int number = tracking;
        while(number++ < str.length()) {
            if(!Character.isDigit(ch) && !Character.isSpaceChar(ch)) {
                return false;
            }else if(Character.isSpaceChar(ch)) {
                break;
            }
            getNextChar();
        }
        return true;
    }

    /**
     * 针对多个空格
     */
    public boolean isSpaceChar() {
        return true;
    }

}
