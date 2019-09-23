package design.model.singleton;

/**
 * 单例模式/懒汉/多线程
 *
 * 多线程：安全
 * Lazy初始化：是
 */
public class Singleton_lazy_thread {

    private static Singleton_lazy_thread instance;

    private Singleton_lazy_thread() {
    }

    //多加同步机制的关键字synchronized
    public static synchronized Singleton_lazy_thread getInstance() {
        if (instance == null) {
            instance = new Singleton_lazy_thread();
        }
        return instance;
    }
}
