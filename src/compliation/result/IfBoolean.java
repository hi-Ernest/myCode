package compliation.result;

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

        for(int i=0;i<list.size();i++){
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
                memoryIndex = index;
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
}
