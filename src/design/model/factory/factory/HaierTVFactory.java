package design.model.factory.factory;

import design.model.factory.simpleFactory.HaierTV;
import design.model.factory.simpleFactory.TV;

public class HaierTVFactory implements TVFactory {
    @Override
    public TV produceTV() {
        System.out.println("海尔电视机工厂生产海尔电视......");
        return new HaierTV();
    }
}
