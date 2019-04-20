package compliation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author chr
 * @Date 4/19/2019 12:11 PM
 * @Version 2.0
 */
public class SplitIdentifier_2 {

    public List recognizeId(String str) {
        List<String> list = new ArrayList<>();
        Map map = new HashMap();
        map.put(1, "||");
        map.put(2, "&&");
        map.put(3, "<");
        map.put(4, "<=");
        map.put(5, ">");
        map.put(6, ">=");
        map.put(7, "==");
        map.put(8, "!");
        map.put(10, "(");
        map.put(11, ")");

        int i=0;
        int j=0;
        while (i<str.length()) {
            if(Character.isDigit(str.charAt(i)) || Character.isLetter(str.charAt(i))) {
                i++;
                continue;
            }else if (map.containsValue(str.charAt(i))) {
                if(j!=i){
                    list.add(str.substring(j, i));
                }
                list.add(str.substring(i, i+1));
                j=i+1;
            }
            i++;
        }
        if(j<str.length())
            list.add(str.substring(j));

        return list;
    }

    public static void main(String []args) {
        SplitIdentifier_2 splitIdentifier = new SplitIdentifier_2();

        String str = "a+d)dd";
        List<String> list = splitIdentifier.recognizeId(str);


        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println(list.size());

    }

}
