public class TStackNode<E> {
    private E data;
    private TStackNode prev;

    public TStackNode(E data, TStackNode prev) {
        this.data = data;
        this.prev = prev;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public TStackNode getPrev() {
        return prev;
    }

    public void setPrev(TStackNode prev) {
        this.prev = prev;
    }
}
