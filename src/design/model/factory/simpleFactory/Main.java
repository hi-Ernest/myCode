package design.model.factory.simpleFactory;

public class Main {

    public static void main(String[] args) {
        String a = new String("aa");

        String aa = a.intern();

        String c = new String("aa");

        String cc = c.intern();

        String b = "aa";

        Integer q = 11;

        Integer p = new Integer(11);

        Integer d = new Integer(11);

        Integer m = 11;

        System.out.println(cc == aa); //true
    }

}
//public class Client {
//    public static void main(String[] args) {
//        SimpleFactory simpleFactory = new SimpleFactory();
//        Product product = simpleFactory.createProduct(1);
//// do something with the product
//    }
//}


//public interface Product {
//}
//public class ConcreteProduct implements Product {
//}
//public class ConcreteProduct1 implements Product {
//}
//public class ConcreteProduct2 implements Product {
//}