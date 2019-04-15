package design.model.factory.factory;

/**
 * 简单工厂模式
 *
 * 不一定接口也可以用抽象类
 * 抽象类中的方法可实现也可定义为抽象方法，留给子类实现
 *
 * 子类可以覆盖父类的抽象方法，没有覆盖的方法而父类实现的也能使用
 *
 */
public interface TV {

    public void play();
}
