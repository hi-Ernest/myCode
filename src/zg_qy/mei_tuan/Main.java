package zg_qy.mei_tuan;

public class Main {


    public static void main(String[] args) {

        String[] strs = {"200.00","201.15","1015","200001010200"};

        String test = "200.00";

        String s = "";

        int i=0;
        while (test.length()!=0) {
            if (test.charAt(i)!='.') {
                i++;
                continue;
            }else {

            }
        }

        System.out.println(Integer.valueOf(test));
    }



}
