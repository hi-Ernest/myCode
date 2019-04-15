package design.model.factory.factory;

import design.model.factory.simpleFactory.TV;

/**
 * 抽象工厂类可以是接口也可以是抽象类
 * 包含抽象工厂produceTV()，返回一个抽象产品TV类型的对象
 */
public interface TVFactory {

    public TV produceTV();
}
