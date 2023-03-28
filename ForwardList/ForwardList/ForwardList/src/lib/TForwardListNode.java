package lib;

public class TForwardListNode<E> {
    private E data;
    private TForwardListNode<E> next;

    public TForwardListNode(E data, TForwardListNode<E> next) {
        this.data = data;
        this.next = next;
    }

    public TForwardListNode(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public TForwardListNode<E> getNext() {
        return next;
    }

    public void setNext(TForwardListNode<E> next) {
        this.next = next;
    }
}
