package design.model.factory.factory;

import design.model.factory.simpleFactory.HisenseTV;
import design.model.factory.simpleFactory.TV;

public class HisenseTVFactory implements TVFactory {
    @Override
    public TV produceTV() {
        System.out.println("海信电视机工厂生产海信电视......");
        return new HisenseTV();
    }
}
