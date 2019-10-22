package zy_java_base;

//public class Singleton {
//
//    private static Singleton instance;
//
//    private Singleton() {}
//
//    public static Singleton getInstance() {
//
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }
//}

//
//public class Singleton {
//
//    private static Singleton instance = new Singleton();
//
//    private Singleton(){}
//
//    public static Singleton getInstance() {
//        return instance;
//    }
//}

//public class Singleton {
//
//    private static Singleton instance;
//
//    private Singleton() {}
//
//    public static synchronized Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }
//}

//public class Singleton {
//
//    private volatile static Singleton instance;
//
//    private Singleton() {}
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            synchronized (Singleton.class) {
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }
//}


public class Singleton {

    private static Singleton instance;

    private Singleton() {}

    private static class InnerClass {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return InnerClass.INSTANCE;
    }
}




















