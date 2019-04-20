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
 * @Date 4/18/2019 10:20 PM
 * @Version 1.0
 */
public class Parser_bool {

    /**
     * 逻辑运算：a||b a&&b !a
     * 关系运算：< <= > =>
     * 相等运算  == !=
     */
    private String token;

    private List<String> list;

    private Map map;

    private int index = 0;

    private boolean flag = true;

    public Parser_bool(List<String> list) {
        map = new HashMap();

        map.put(1, "||");
        map.put(2, "&&");
        map.put(3, "<");
        map.put(4, "<=");
        map.put(5, ">");
        map.put(6, ">=");
        map.put(7, "==");
        map.put(8, "!");
        map.put(9, "i");
        map.put(10, "(");
        map.put(11, ")");

        Map map2 = new HashMap();
        map2.putAll(map);
        map2.remove(9);

        for(int i=0;i<list.size();i++){
            if(!map2.containsValue(list.get(i)))
                list.set(i, "i");
        }
        System.out.println(list);

        this.token = list.get(index);
        this.list = list;
    }


    public boolean B() {
        T();
        B1();

        System.out.println(index);
        return flag;
    }

    public void B1() {
        if(token.equals("&&")){
            token= "";
            match("&&");
            T();
            B1();
        }
    }

    public void T() {
        F();
        T1();
    }

    public void T1() {
        if(token.equals("||")) {
            token = "";
            match("||");
            F();
            T1();
        }
    }

    public void F() {
        if(token.equals("(")) {
            match("(");
            B();
            if(token.equals(")")) {
                match(")");
            }
            else
                error();
        }
        else if(token.equals("i")) {
            match("i");
            if(token.equals("i"))
                error();
        }
        else if(token.equals("!")){
            match("!");
            F();
        }
        else
            error();
    }

    public void match(String input) {
        if(index+1 < list.size()) {
            if (map.containsValue(input))
                token = getNextToken();
        }
//        System.out.println(index);
    }

    public String getNextToken() {
        index++;
        return list.get(index);
    }

    public void error() {
        this.flag = false;
    }

    public static void main(String[] args) throws IOException {
        String expr;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入一个空的字符串则结束.....");

        while (true) {
            System.out.println("请输入你的布尔表达式： ");
            expr = br.readLine();
            if("".equals(expr))
                break;

            Identifier identifier = new Identifier();

            List<String> list = new ArrayList<>();
            list = identifier.identifier(expr, list);

            Parser_bool pb = new Parser_bool(list);

            if(pb.B())
                System.out.println("布尔表达式正确");
            else
                System.out.println("表达式错误");
        }

    }
}
