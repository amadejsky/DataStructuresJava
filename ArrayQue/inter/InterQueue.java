package inter;

public interface InterQueue<E> {
    boolean put(E element);
    E top();
    E get();
    boolean pop();
    boolean isEmpty();
    boolean isFull();
    int size();
}

