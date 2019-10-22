package design.model.proxy;

public class ProxyImage implements Image {

    private RealImage realImage;

    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;

    }

    @Override
    public void display() {

        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }


    public static void main(String[] args) {
        Image image = new ProxyImage("test.jpg");

        //图像从磁盘加载
        image.display();

        System.out.println();

        //图形不需要从磁盘加载
        image.display();
    }
}
