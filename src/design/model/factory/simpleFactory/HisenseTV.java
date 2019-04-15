package design.model.factory.simpleFactory;

public class HisenseTV implements TV {
    @Override
    public void play() {
        System.out.println("海信电视机正在播放.....");
    }
}
