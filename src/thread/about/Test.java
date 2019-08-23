package thread.about;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        System.out.println(list.get(0).getClass()==Double.class);
    }
}
