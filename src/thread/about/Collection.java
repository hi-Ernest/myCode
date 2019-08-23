package thread.about;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Vector是同步的,开销较大,访问速度庚慢
 * 最好使用ArrayList
 *
 * 同步可以完全由程序员控制
 *
 *
 *
 */
public class Collection {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        /**
         * Conllections.synchronizedList()
         * 可得到线程安全的List
         */
        List<String> synList = Collections.synchronizedList(list);


        /**
         * concurrent包下的 CopyOnWriteArrayList
         *
         * 读写分离：
         *      写操作在一个复制的数组上进行，读操作还是在原始数组中进行，读写分离，互不影响。
         *      写操作需要加锁，防止并发写入时导致写入数据丢失。
         *      写操作结束之后需要把原始数组指向新的复制数组。
         *
         * 适用场景：
         *      写操作的同时允许读操作，大大提高了读操作的性能，因此很适合读多写少的应用场景。
         *
         * 缺陷：
         *      内存占用：在写操作时需要复制一个新的数组，使得内存占用为原来的两倍左右；
         *      数据不一致：读操作不能读取实时性的数据，因为部分写操作的数据还未同步到读数组中。
         *
         *      所以 CopyOnWriteArrayList 不适合内存敏感以及对实时性要求很高的场景。
         *
         */
        List<String> list2 = new CopyOnWriteArrayList<>();


        /**
         * linkedList源码分析： 基于双向链表实现
         */
        List<Integer> linkedList = new LinkedList<>();

        /**
         *
         */
        Map<String, Integer> map = new HashMap();




//        List<Object> lists = new ArrayList<>();
//
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(1);
//        list1.add(3);
//
//        List<Integer> list3 = new ArrayList<>();
//        list3.add(1);
//        list3.add(1);
//
//        List<List<Integer>> list4 = new ArrayList<>();
//        list4.add(list1);
//        list4.add(list3);
//
//
//        lists.add(list1);
//        lists.add(list3);
//        lists.add(list4);
//
//        System.out.println(lists);
//
//        System.out.println(getArray(lists));

    }

    public static Set<Integer> getArray(List<Object> obj){
//        ArrayList<Integer> integers = new ArrayList<>();

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < obj.size(); i++){
            if (obj.get(i).getClass() == Integer.class){
                set.add((Integer) obj.get(i));
            }else {
                set.addAll(getArray((List<Object>) obj.get(i)));
            }
        }
        return set;
    }

}
