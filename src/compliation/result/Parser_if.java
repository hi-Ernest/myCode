package compliation.result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author chr
 * @Date 4/19/2019 5:20 PM
 * @Version 1.0
 */
public class Parser_if {

    private List<String> list;

    private String token;

    private boolean flag = true;

    private int index = 0;

    private Map map;

    public Parser_if(List<String> list) {
        getMap();

        for(int i=0;i<list.size();i++){
            if(!map.containsValue(list.get(i)))
                list.set(i, "i");
        }

        System.out.println(list);

        this.list = list;
        this.token = list.get(index);
    }

    public boolean E() {
        if(!token.equals("if")) {
            return error();
        }

        getNextToken();

        if(!token.equals("(")) {
            return error();
        }

        getNextToken();

        int memoryIndex = index;
        //判断if()中的语句是否正确
        IfBoolean ifBoolean = new IfBoolean(list, index);
        if(ifBoolean.B()){
            index = ifBoolean.index;
            memoryIndex = ifBoolean.memoryIndex;
            System.out.println(memoryIndex);
        }
        else
            error();

        index = memoryIndex;
        token = list.get(index);

        if(!token.equals(")")) {
            return error();
        }else {
            getNextToken();
            IfParser_2 ifParser2 = new IfParser_2(list, index);
            if(ifParser2.E()) {
                //扫描到"else"
                index = ifParser2.index;
                token = list.get(index);
            }

            if(token.equals("else")){
                getNextToken();
                IfParser_2 ifParser21 = new IfParser_2(list, index);
                if(!ifParser21.E()) {
                    flag = false;
                }
            }
        }

        return flag;
    }


    private void getNextToken() {
        if(index+1<list.size()) {
            index++;
            token = list.get(index);
        }else {
            error();
        }

    }

    //处理出错
    private boolean error() {
        System.out.println("if语句错误");
        return false;
    }

    public static void main(String[] args) throws IOException {
        String expr;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入一个空的字符串则结束.....");

        while (true) {
            System.out.println("请输入你的if语句表达式： ");
            expr = br.readLine();
            if("".equals(expr))
                break;

            Identifier identifier = new Identifier();

            List<String> list = new ArrayList<>();

            list = identifier.identifier(expr, list);


            System.out.println(list);

            Parser_if pi = new Parser_if(list);

            if(pi.E())
                System.out.println("if语句正确");
        }

    }

    private void getMap() {
        map = new HashMap();
        map.put(1, "+");
        map.put(2, "-");
        map.put(3, "*");
        map.put(4, "/");
        map.put(5, "(");
        map.put(6, ")");
        map.put(7, "i");
        map.put(8, "||");
        map.put(9, "&&");
        map.put(10, "<");
        map.put(11, "<=");
        map.put(12, ">");
        map.put(13, ">=");
        map.put(14, "==");
        map.put(15, "!");
        map.put(18, "if");
        map.put(19, "else");
    }
}

