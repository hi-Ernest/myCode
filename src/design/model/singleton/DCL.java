package design.model.singleton;

/**
 * 单例模式/(双检锁/双重校验锁 or double-checked locking)
 * JDK1.5起
 * <p>
 * 多线程：安全
 * Lazy初始化：是
 * <p>
 * 双锁机制 在安全且多线程情况下能保持高性能
 */
public class DCL {

    private static volatile DCL singleton;

    private DCL() {
    }

    //双重检验锁
    //两次检验同步块 可能会有多个线程进入同步块外的if 不二次检验的话会生成多个实例
    public static DCL getInstance() {
        if (singleton == null) {
            synchronized (DCL.class) {
                singleton = new DCL();
            }
        }

        return singleton;
    }
}
