package zy_jvm;

/**
 * 类加载的时候 ——> 执行定义的Java代码
 *
 * 初始阶段是JVM执行类构造器<client>()方法的过程
 *
 * 准备阶段：类变量已经赋过一次系统的初始值
 * 初始化阶段,根据程序员通过程序制定的主观计划去初始化 类变量和其它资源
 *
 *
 */
public class Test {

    static class Parent {
        public static int A = 1;

        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
    //由于父类的 <clinit>() 方法先执行,也就意味着父类中定义的静态语句块的执行要优先于子类
    //输出：2


}
