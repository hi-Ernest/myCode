package design.model.singleton;

//IDEA默认可以构造饿汉模式

//public class Singleton {
//    private static Singleton ourInstance = new Singleton();
//
//    public static Singleton getInstance() {
//        return ourInstance;
//    }
//
//    private Singleton() {
//    }
//}


/**
 * JDK 版本：JDK1.5 起
 * <p>
 * 是否 Lazy 初始化：否
 * <p>
 * 是否多线程安全：是
 * <p>
 * 实现难度：易
 */
public enum Singleton {
    INSTANCE;

    public void whateverMenthod() {

    }
}

