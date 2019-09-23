package zg_qy.teng_xu;

import java.util.*;

public class Fenzu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groups = Integer.parseInt(scanner.nextLine().trim());

        List<List<Integer>> lists = new ArrayList<>();

        for (int i=0; i<groups; i++) {
            int nums = Integer.parseInt(scanner.nextLine().trim());
            List<Integer> list = new ArrayList<>();
            for (int j=0; j<nums; j++) {
                list.add(scanner.nextInt());
            }
            lists.add(list);
            String  a = scanner.nextLine();
        }

//        System.out.println(Arrays.toString(lists.toArray()));
        //[[5, 9, 4, 7], [9, 13, 18, 10, 12, 4, 18, 3]]

        Fenzu main = new Fenzu();
//        List<List<Integer>> result = main.getResult(lists);

//        for(List list : result){
//            for(Object i : list) {
//                System.out.print(i+ " ");
//            }
//            System.out.println();
//        }

    }


//    public List<List<Integer>> getResult(List<List<Integer>> lists) {
//        List<List<Integer>> result = new ArrayList<>();
//
//        for (int i=0; i<lists.size(); i++) {
//            Collections.sort(lists.get(i));
//            int len = lists.get(i).size();
//            int begin = 0;
//            int count = len/2;
//            List<Integer> list = new ArrayList<>();
//            int temp =0;
//            int temp2 =0;
//            int p =0, q=1;
//
////            System.out.println(Arrays.toString(lists.get(i).toArray()));
//
//            while (begin < count) {
//                temp = temp + lists.get(i).get(p);
//                temp2 = temp2 + lists.get(i).get(q);
//                p = p+2;
//                q =q+2;
//                begin++;
//            }
//            System.out.println(temp +" "+ temp2+"\n");
//            list.add(temp);
//            list.add(temp2);
//            result.add(list);
//        }
//
//        return result;
//    }


//    public List<List<Integer>> getResult(List<List<Integer>> lists) {
//        List<List<Integer>> result = new ArrayList<>();
//
//        for (int i=0; i<lists.size(); i++) {
//            Collections.sort(lists.get(i));
//            int len = lists.get(i).size();
//            int begin = 0;
//            int count = len/2;
//            List<Integer> list = new ArrayList<>();
//            int temp =0;
//            int temp2 =0;
//            int p =0, q=1;
//
////            System.out.println(Arrays.toString(lists.get(i).toArray()));
//
//            for (int p)
//                temp = temp + lists.get(i).get(p);
//                temp2 = temp2 + lists.get(i).get(q);
//                p = p+2;
//                q =q+2;
//                begin++;
//            }
//            System.out.println(temp +" "+ temp2+"\n");
//            list.add(temp);
//            list.add(temp2);
//            result.add(list);
//        }
//
//        return result;
//    }
//


}
