package zy_java_base;

public class OuterClass {

    class InnerClass {

    }

    static class staticInnerClass {

    }

    public static void fun(){

    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        InnerClass i = outerClass.new InnerClass();

        staticInnerClass s = new staticInnerClass();
    }
}
