package zg_qy.qi_an_xin;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] childs = new int[100];

        int[] parents = new int[100];

        Map<Integer, Integer> map = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        int index=0;
        while (scanner.hasNext()) {
            int in = scanner.nextInt();
            if (in == 0)
                break;
            childs[index++] = in;
        }

        int index2 = 0;
        while (scanner.hasNext()) {
            int in = scanner.nextInt();
            if (in == index)
                break;
            parents[index2++] = in;
        }


        int number = scanner.nextInt();


        for (int i=0; i<=index; i++) {
            map.put(parents[index], childs[index]);
        }


        Main main = new Main();

        System.out.println(main.getCount((HashMap<Integer, Integer>) map,number));


//                <0,3> <3,1> <3,5> <1,3> <5,3>

//        System.out.println(Arrays.toString(childs));
//        System.out.println(Arrays.toString(parents));
    }


    public int getCount(HashMap<Integer, Integer> map, int number) {

        if (!map.containsKey(number)) {
            return 0;
        }

        int count =0;
        for (Integer value : map.values()) {
            if (number == value) {
                count++;
            }
        }

        return count++;
    }


}
