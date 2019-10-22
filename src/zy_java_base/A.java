package zy_java_base;

public class A {

    public static void main(String[] args) {

        char c = 9999;

        long y = 1234567891;

        long x = 1;

        Long g = 55L;

        long o = 4990;

        float f = 1.1f;

        float ffff = 1234567891;

        float ff = -767890789;

        float fff = 1;

        double d = 34.4;


        int i =0;
        int j= i++;

        int p = ++i;
        System.out.println(j);
        System.out.println(p);

        if ((j>++j)&&(i++==j)) {
            j+=i;
        }

        System.out.println(j);

        int a = 1;
        int b = 2;
        int r;
        int u = 0;

        u-= r = (a++) + --b;
        System.out.println(r);
        System.out.println(u);
        System.out.println(a);
        System.out.println(b);
    }


    //类方法
    public static int test(){
        System.out.println("ddd");


        t();

        return 1;
    }

    public void tt(){
        System.out.println("this is ");
    }

    public static void t(){}

//    public static void main(String[] args) {
//
//        A a = new A();
//        System.out.println(a.fun(2));
//
//    }

    int fun(int n) {
        if (n == 5)
            return 2;
        else
            return 2*fun(n+1);
    }
}
