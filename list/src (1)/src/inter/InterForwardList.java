package inter;

public interface InterForwardList<E> {
    int size();
    boolean isEmpty();

    boolean addFirst(E e);
    boolean add(E e);
    void add(int index, E element);

    void clear();
    E removeFirst();
    E removeLast();
    E remove(int index);

    E get(int index);
    E set(int index, E element);

    int indexOf(E element);
}
