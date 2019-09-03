//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int N, M;
//
//        while (scanner.hasNextInt()) {
//            N = scanner.nextInt();
//            M = scanner.nextInt();
//
//            System.out.println(String.format("%d%d", N, M));
//
//            //读取下一行
//            for (int i=0; i<M; i++) {
//                //读取每行的a b c
//                int a =scanner.nextInt(),
//                 b =scanner.nextInt(),
//                 c =scanner.nextInt();
//                System.out.println(String.format("%d%d%d", a, b, c));
//            }
//        }
//    }
//}
import java.util.*;

class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
//
//        int[] nums = new int[N+1];
//        String[] options = new String[N];
//
//
//        int i =0;
//        while(scanner.hasNext()) {
//            nums[i] = scanner.nextInt();
//            options[i] = scanner.next();
//        }
//
//        System.out.println(nums+" "+options);

        Main main = new Main();

//        System.out.println(main.getNumbers(3));
//
        List<Integer> list = new ArrayList<>();

        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();

        char[] c = str.toCharArray();


        int begin = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ',' && begin != i) {
                list.add(Integer.valueOf(str.substring(begin, i).trim()));
                begin = i;
            } else if (c[i] == ' ') {
                begin++;
            }
        }

        list.add(Integer.valueOf(str.substring(begin).trim()));


        System.out.println(main.getPair(list));

    }

    public int getPair(List<Integer> nums) {

        int count = 0, len = nums.size();
        Map<Integer, Integer> less = new HashMap<>();

        //将List中的负数提取出来 --> 绝对值转化成正数
        for (int i = 0; i<len; i++) {
            if (nums.get(i) < 0) {
                less.put(Math.abs(nums.get(i)), i);
            }
        }

        //再次循环,略过已经提取的数,找数值相同的元素即可
        for (int j=0; j<len; j++) {
            if (!less.containsValue(j)) {
                if (less.containsKey(nums.get(j))) {
                    count++;
                }
            }

        }

//        for (int i = 0; i < len - 1; i++) {
//            for (int j = i + 1; j < len; j++) {
//                if (nums.get(i) + nums.get(j) == 0) {
//                    count++;
//                }
//            }
//        }

        return count;
    }


    public int getPair(int[] nums) {

        int count = 0, len = nums.length;


        for (int i = 0; i <= len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }


//    public static int climbStairs(int n) {
//        if (n <= 2) {
//            return n;
//        }
//        int pre2 = 1, pre1 = 2;
//        for (int i = 2; i < n; i++) {
//            int cur = pre1 + pre2;
//            pre2 = pre1;
//            pre1 = cur;
//        }
//        return pre1;
//    }


    public int getNumbers(int num) {

        if (num  == 1) {
            return 0;
        }

        int count = 0;
        while (num != 0) {

            if (num == 1)
                break;

            if (num%2 == 1) {
                count++;
            }
            num/=2;
        }
        return count;

    }
}
