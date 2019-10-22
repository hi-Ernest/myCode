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

    //必须加上volatile
    //使用 volatile 可以禁止 JVM 的指令重排,保证在多线程环境下也能正常运行。
    private static volatile DCL singleton;

    private DCL() {
    }

    //双重检验锁
    //两次检验同步块 可能会有多个线程进入同步块外的if 不二次检验的话会生成多个实例
    public static DCL getInstance() {

        //先判断对象是否已经实例过,没有实例化过才进入加锁代码
        if (singleton == null) {
            //类对象加锁
            synchronized (DCL.class) {
                singleton = new DCL();
            }
        }

        return singleton;
    }

    /**
     * 笔记：
     *  1. singleton = new DCL();
     *      1)为singleton分配内存空间
     *      2)初始化singleton
     *      3)将singleton指向分配的内存地址
     *
     *  使用 volatile 可以禁止 JVM 的指令重排,保证在多线程环境下也能正常运行
     *  不然可能 1-3-2执行顺序
     */
}
