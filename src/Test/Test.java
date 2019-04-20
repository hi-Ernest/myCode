package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    private static List<String> list1;

    private int index = 0;
    public static void main(String[] args) {
       int a =0;
       int b =1;
       int c=0;
        Map map = new HashMap();

        map.put(1, "2");
        map.put(2, "-");
        map.put(3, "*");
        map.put(4, "/");
        map.put(5, "(");
        map.put(6, ")");

       List<String> list = new ArrayList<>();

       list.add("1");
       list.add("2");
       list.add("3");
       list.add("1");
       list.add("2");
       list.add("3");
       list.add("1");
       list.add("2");
       list.add("3");

       list1 = list;
       Test test = new Test();

//        System.out.println(test.getNextToken());
//        System.out.println(test.getNextToken());

//       if(a==0){
//           if(b!=0){
//               b++;
//           }
//           b++;
//       }

//        System.out.println(b);

       for(int i=0;i<list.size();i++){
          if(!map.containsValue(list.get(i)))
              list.set(i, "0");
       }

        System.out.println(list);

    }
}

