package zy_java_base;

public class AbstractA extends Abstract {

    public AbstractA(){}

    private int i;

    @Override
    void get() {

    }

//    void get2(){
//        System.out.println("8888");
//    }

    public static void main(String[] args) {
        AbstractA a = new AbstractA();
        a.get2();
    }
}
