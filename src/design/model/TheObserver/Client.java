package design.model.TheObserver;

public class Client {

    public static void main(String[] args) {
        MySubject subject = new Cat();

        MyObserver obs1,obs2,obs3;
        obs1 = new Mouse();
        obs2 = new Dog();

        subject.attach(obs1);
        subject.attach(obs2);

        subject.cry();
    }

}
