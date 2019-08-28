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
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] nums = new int[N+1];
        String[] options = new String[N];


        int i =0;
        while(scanner.hasNext()) {
            nums[i] = scanner.nextInt();
            options[i] = scanner.next();
        }

        System.out.println(nums+" "+options);

    }


    public void getResult(){

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

}
