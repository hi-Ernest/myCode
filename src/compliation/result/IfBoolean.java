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
 * @Date 4/20/2019 4:01 PM
 * @Version 1.0
 */
public class IfBoolean {

    /**
     * 逻辑运算：a||b a&&b !a
     * 关系运算：< <= > =>
     * 相等运算  == !=
     */
    private String token;

    private List<String> list;

    private Map map;

    protected int index;

    private boolean flag = true;

    public int memoryIndex=0;

    public IfBoolean(List<String> list, int inputIndex) {
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

        //找到输入的list的")"的位置
        int j = list.size()-1;
        while (j>=0){
            if(list.get(j).equals(")")) {
                memoryIndex = j;
                break;
            }
            j--;
        }

        for(int i=0;i<=memoryIndex;i++){
            if(!map2.containsValue(list.get(i)))
                list.set(i, "i");
        }

        index = inputIndex;
        this.token = list.get(index);
        this.list = list;
    }


    public boolean B() {
        T();
        B1();

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
            if(token.equals("i") && index+1 > list.size())
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
    }

    public String getNextToken() {
        index++;
        return list.get(index);
    }

    public void error() {
        this.flag = false;
    }



//    public static void main(String[] args) throws IOException {
//        String expr;
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("输入一个空的字符串则结束.....");
//
//        while (true) {
//            System.out.println("请输入你的布尔表达式： ");
//            expr = br.readLine();
//            if("".equals(expr))
//                break;
//
//            Identifier identifier = new Identifier();
//
//            List<String> list = new ArrayList<>();
//            list = identifier.identifier(expr, list);
//
//            IfBoolean pb = new IfBoolean(list,0);
//
//            if(pb.B())
//                System.out.println("布尔表达式正确");
//            else
//                System.out.println("表达式错误");
//
//            System.out.println(pb.memoryIndex);
//
//        }
//
//    }

}
