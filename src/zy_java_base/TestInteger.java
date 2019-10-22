package zy_java_base;

public class TestInteger {
    public static void main(String[] args) {
        Integer a = new Integer(1);
        int b = 1;
        Integer c = 1;

        System.out.println(a.equals(b));

        System.out.println(a==c);

        Singleton.getInstance();

    }
}
