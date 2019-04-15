package date.structure;

public abstract class MyAbstractList<E> implements MyList<E>{

    //该列表的元素个数
    protected int size =0;

    public MyAbstractList() {
    }


    public MyAbstractList(E[] objects) {
        for(int i=0; i<objects.length; i++) {
            add(objects[i]);
        }
    }

    @Override
    public void add(E o) {
        add(size, o);
    }

    @Override
    public void add(int index, Object o) {

    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public boolean isEmpty(Object o) {
        return false;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object o) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
