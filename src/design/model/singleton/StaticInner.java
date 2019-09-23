package design.model.singleton;

/**
 * 单例模式/登记式 or 内部静态类
 * <p>
 * 多线程：安全
 * Lazy初始化：是
 */
public class StaticInner {

    //静态内部类 空间换时间-> 登记式模式
    //好处：读取实例的时候不会进行同步，没有性能呢缺陷；也不依赖JDK 本质：JVM本身机制保证了线程安全问题
    private static class SingletonHodler {
        private static final StaticInner INSTANCE = new StaticInner();
    }

    private StaticInner() {
    }


    public static final StaticInner getInstance() {
        return SingletonHodler.INSTANCE;
    }

}
