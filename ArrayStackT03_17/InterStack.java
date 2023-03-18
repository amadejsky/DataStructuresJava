package inter;

public interface InterStack<E> {
    boolean isEmpty();
    E top();
    E pop();
    void push(E item);
    int size();
    int deepLevel(E item);
}
