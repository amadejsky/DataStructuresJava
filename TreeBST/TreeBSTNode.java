package lib;

public class TreeBSTNode<E> {
    protected E data;
    protected TreeBSTNode<E> left;
    protected TreeBSTNode<E> right;

    public TreeBSTNode(E data) {
        this.data = data;
        left = null;
        right = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public TreeBSTNode<E> getLeft() {
        return left;
    }

    public void setLeft(TreeBSTNode<E> left) {
        this.left = left;
    }

    public TreeBSTNode<E> getRight() {
        return right;
    }

    public void setRight(TreeBSTNode<E> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
