package zy_java_base;

/**
 * 总结：
 *      1.抽象类是不能实例化的
 *
 *      2.抽象类可以定义构造方法(函数)
 *           --------------------------------------------------
 *          |不论是抽象还是非抽象类 --> 实例化子类 ---> 先初始化父类|
 *          --------------------------------------------------
 *          子类继承抽象的父类 -> 实例化子类 -> 首先调用父类的构造方法 -> 再调用子类的构造方法
 *          [抽象类中可以使用构造方法 封装继承子类公共的东西]
 *
 *      3.定义抽象类不一定要继承使用
 *          在抽象类中定义静态的方法 -> 如SqlHelper类的 public static Boolean ExecuteSql() -> 在Dao层直接使用
 *          好处： 1)抽象类直接省去类实例化.(类的实例化一定要在堆中new对象, 然后在栈中分配空间指向堆中new的对象)
 *                  省去类这两步
*                 2)抽象类的静态方法是存在内存中的,用的时候直接向内存中存取,提高效率
 *
 *      4.抽象类：一个类有一个或多个抽象方法,类必须指定abstract
 *              抽象方法：属于不完整的方法,只含有一个声明,没有方法主体
 *
 *
 *      5.针对构造方法:
 *              1)子类可以使用super语句调用父类的构造方法
 *              2)构造方法可以重载
 *
 *
 *
 *
 */
public class Program {

    public static void main(String[] args) {
        TestAbstract t = new TestAbstract();

        System.out.println(t);
    }
}



abstract class BaseAbstract {

    public BaseAbstract() {
        System.out.println("抽象方法");
    }
}

class TestAbstract extends BaseAbstract {

    public TestAbstract() {
        System.out.println(("子类方法"));

    }
}




