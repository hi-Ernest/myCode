package design.model.singleton;

/**
 * 单例模式
 * 懒汉和饿汉
 *
 * 1.双重检验锁
 * 2.静态内部类
 */
public class Singleton_total {

   //加上volatile 在JVM的即时编译器中存在指令重排序优化 步骤顺序不能保证
   private volatile static Singleton_total instance;

   public Singleton_total() {
      // TODO: implement
   }

   //多个线程使用的情况->保持线程安全 不会创建多个实例
   //synchronized 设置为同步
   //懒汉模式
//   public static synchronized Singleton getInstance() {
//      if(instance == null)
//         instance = new Singleton();
//     return null;
//   }

   //双重检验锁
   //两次检验同步块 可能会有多个线程进入同步块外的if 不二次检验的话会生成多个实例
//   public static Singleton getInstance() {
//      if(instance == null) {
//         synchronized (Singleton.class) {
//            if(instance == null) {
//               instance = new Singleton();
//            }
//         }
//      }
//      return instance;
//   }


   //静态内部类 空间换时间-> 登记式模式
   //好处：读取实例的时候不会进行同步，没有性能呢缺陷；也不依赖JDK 本质：JVM本身机制保证了线程安全问题
   private static class SingletonHolder {
      private static final Singleton_total INSTANCE = new Singleton_total();

   }


   //只能通过该公有的方法访问到
   public static final Singleton_total getInstance() {
      return SingletonHolder.INSTANCE;
   }

}