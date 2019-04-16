package compliation;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

/**
 * a+e+67/9*
 *
 * char[] c = {'+' ,'-', '*', '/', '(', ')'};
 * ɨ��
 */
public class SplitIdentifier {

    //ָ��ɨ�赽��λ��
    private static int tracking  = 0;

    //�ַ�����(���¶�����ַ�)
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

        //һ��ʼ������״̬(��֮�µ��ж������Ľ���)
        char state = '0';

        //����while���������
        while (tracking < str.length()) {
            getNextChar();
//            getBc();

            while(state != '2') {
                switch (state) {
                    //��������ĸ�����
                    case '0': if(Character.isLetter(ch)) {
                        System.out.print(ch);
                        getNextChar();
                        state = '1';
                        break;
                    //ɨ�赽�ո����Թ�
                    } else if(Character.isSpaceChar(ch)) {
                        getNextChar();
                        state = '0';
                        break;
                    //��һ��������(�жϸõ�һ���ַ�֮����ַ��Ƿ�������-->ֱ���ո�����ַ�������)
                    } else if(Character.isDigit(ch)) {
                        int start = tracking;
                        if(isNumbers()) {
                            System.out.println(str.substring(start-1, tracking));

                            list.add(str.substring(start-1, tracking));
                            state = '0';
                            break;
                        }
                        //����(��:5632Good)��
                        else {
                            //���벻���Ϲ淶
                            error();

                            //�ַ�һֱ����Ȼ�󵽿ո���ܵ�һ���ַ������state='0'
                            if (getPosition()) {
                                getNextChar();
                                state = '0';
                            }else
                                state = '2';
                            break;
                        }
                    }
                    //��һ���ַ��Ȳ�����ĸҲ��������-->����ʾ������Ϣ���Թ�
                    else {
                        //���벻���Ϲ淶
                        error();

                        //�ַ�һֱ����Ȼ�󵽿ո���ܵ�һ���ַ������state='0'
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
     * ������һ���ַ�
     * @return
     */
    public void getNextChar() {
        ch = str.charAt(tracking);
        tracking++;
    }

    /**
     * ��������ַ��Ƿ�հ�
     * �ǵĻ��͵���getNextChar,ֱ����һ���ַ�����
     */
    public void getBc() {
        while (Character.isSpaceChar(ch))
            getNextChar();
    }

    /**
     * ��Ա���û�п��ǵ����
     */
    public static void error() {
        System.out.println("���ִ���");
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
     * ���ʶ�����ֵ�����
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
     * ��Զ���ո�
     */
    public boolean isSpaceChar() {
        return true;
    }

}
