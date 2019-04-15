package date.structure;

public interface MyList<E> {

    void add(E e);

    void add(int index, E e);

    void clear();

    boolean contains(E e);

    E get(int index);

    int indexOf(E e);

    boolean isEmpty(E e);

    int lastIndexOf(E e);

    boolean remove(E e);

    E remove(int index);

    Object set(int index, E e);

    int size();

}
