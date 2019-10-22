package zy_java_base;

public class Static {
    static {
        System.out.println("static");
    }

    public Static() {
        System.out.println("a");
    }

    static {
        System.out.println("static2");
    }

    public static void main(String[] args) {
        Static s = new Static();
    }
}
