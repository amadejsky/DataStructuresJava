package lib;

public class TQueueNode<E> {
    private E data;
    private TQueueNode<E> ptr;

    public TQueueNode(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public TQueueNode<E> getPtr() {
        return ptr;
    }

    public void setPtr(TQueueNode<E> ptr) {
        this.ptr = ptr;
    }
}