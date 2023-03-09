public interface InterStackE<E> {
    boolean isEmpty();
    E top();
    E pop();
    int size();
    int deepLevel(E item);
    void push(E item);
}
