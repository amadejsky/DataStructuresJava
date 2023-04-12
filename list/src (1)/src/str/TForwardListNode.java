package str;

//import inter.InterForwardListNode;
import java.util.Iterator;

public class TForwardListNode<E> {
    protected E data;
    protected TForwardListNode<E> next = null;

    public TForwardListNode(E data) {
        this.data = data;
        next = null;
    }

    public TForwardListNode<E> getNext() {
        return next;
    }

    public void setNext(TForwardListNode<E> next) {
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
