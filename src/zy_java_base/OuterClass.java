//package zy_java_base;
//
///**
// * 1.能否引用外部类的静态变量
// * 2.是否能申明静态变量
// */
//public class OuterClass {
//    private int id;
//    public String name;
//    private static int flag;
//
//    class InnerClass {
//        private int id2;
//        private String address;
//
//        //2.
//        private static int uu;
//
//        public void menthod() {
//            flag = 4;
//            id = 8;
//        }
//    }
//
//    //静态内部类不能访问外部类的非静态成员(包括非静态变量和非静态方法)
//    //静态内部类只能访问外部类的静态成员(包括静态变量和静态方法)
//    static class staticInnerClass {
//        private static int uu;
//
//        public void menthod(){
//            flag = 4;
//        }
//
//    }
//
//    public static void fun(){
//        private static int uu;
//
//    }
//
//    public static void main(String[] args) {
//        OuterClass outerClass = new OuterClass();
//        InnerClass i = outerClass.new InnerClass();
//
//        staticInnerClass s = new staticInnerClass();
//    }
//}
