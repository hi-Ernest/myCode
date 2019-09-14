package zy_java_base;

/**
 * {一系列方法的声明,是一些方法特征的集合,只有特征没有方法的实现}
 * 接口:
 *      1.不能使用构造方法
 *          [原因：1)构造方法是用于初始化成员变量,但接口的成员变量是常量,无需修改
 *                  接口是一种规范,被调用时,主要关注里面的方法,而方法不需要初始化
*                 2)类可以实现多个接口,若多个接口都有自己构造器,则不好决定构造器的调用次序
 *                3)构造器属于类自己的,不能被继承.因为是虚的,接口不需要构造器
 *          ]
 *
 *  &&&接口和抽象类的语法区别：
 *          1.构造方法
 *          2.方法体
 *          3.静态方法
 *          4.接口中凡是变量必须是 public static final
 *            抽象类无
 */
public interface Interface {

//    public Interface() {
//
//    }


    public static final int i = 8;

    static final boolean flag = true;

    int j = 0;


}
