package design.model.singleton;

/**
 * 单例模式/饿汉
 *
 * 多线程：安全
 * Lazy初始化：否
 */
public class Singleton_hungry {

    private static Singleton_hungry instance = new Singleton_hungry();

    private Singleton_hungry() {
    }

    public static Singleton_hungry getInstance() {
        return instance;
    }
}
