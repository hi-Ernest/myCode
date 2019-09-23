package zg_qy.teng_xu;

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
        Scanner scanner = new Scanner(System.in);

        int groups = Integer.parseInt(scanner.nextLine().trim());
        int[] lens = new int[groups];
        String[] strs = new String[groups];

        int index = 0;
        for (int i=0; i<groups; i++) {
            lens[index] = Integer.parseInt(scanner.nextLine().trim());
            strs[index] = scanner.nextLine();
            index++;
        }

        Main main = new Main();

        List<Boolean> result = main.isPhone(strs, lens);

        for(Boolean b : result) {
            if (b == false)
                System.out.println("NO");
            else
                System.out.println("YES");
        }




//        System.out.println(groups);
//        System.out.println(Arrays.toString(lens));
//        System.out.println(Arrays.toString(strs));
    }


    public List<Boolean> isPhone(String[] strs, int[] lens) {
        List<Boolean> result = new ArrayList<>();

        for (int i=0; i<strs.length; i++) {
            if (strs[i].length() != lens[i] || strs[i].length() < 11) {
                result.add(false);
            }else if ((strs[i].length() == 11 && strs[0].charAt(0) != 8) || strs[i].equals("13888888888")){
                System.out.println( strs[0].charAt(0));
                result.add(false);
            }else {
                result.add(true);
            }
        }

        return result;
    }


}
