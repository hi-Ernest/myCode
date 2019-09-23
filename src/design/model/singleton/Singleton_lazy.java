package design.model.singleton;

/**
 * 单例模式/懒汉
 *
 * 多线程：不安全
 * Lazy初始化：是
 */
public class Singleton_lazy {

    private static Singleton_lazy instance;

    private Singleton_lazy() {
    }

    public static Singleton_lazy getInstance() {
        if (instance == null) {
            return instance = new Singleton_lazy();
        }
        return instance;
    }

}
