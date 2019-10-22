package zg_qy.qi_niu_cloud;

import java.util.*;

public class Main {

    static String noResult = "-1 -1";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();

        int[] array = new int[len];

        for (int i=0; i<array.length; i++) {
            array[i] = scanner.nextInt();
        }

        int result = scanner.nextInt();

        Main main = new Main();
        main.getResult(result, array);
    }


    public void getResult(int result, int[] array) {

        Arrays.sort(array);
        if (result <= array[0] || array.length < 2)
            System.out.println(noResult);
        else {
            List<Integer> list = new ArrayList<>();

            for (int i=0; i<array.length-1; i++) {
                int temp = array[i];
                for (int j=i+1; j<array.length-1-i; j++) {
                    if (array[j] == result-temp) {
                        list.add(i);
                        list.add(j);
                    }
                }
            }

            if (list.size() == 0)
                System.out.println(noResult);
            else {
                for (int t : list) {
                    System.out.print(t+" ");
                }
            }
        }
    }
}
