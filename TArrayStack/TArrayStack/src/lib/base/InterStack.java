package lib.base;

public interface InterStack<E> {
    E top();
    E pop();
    void push(E item);
    boolean isEmpty();
    int size();
    int deepLevel(E item);
}
