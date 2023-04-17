package lib;

import java.util.Iterator;

public class TQueueIterator<E> implements Iterator<E> {
    private TQueueNode<E> actualReference;

    public TQueueIterator(TQueueNode<E> actualReference) {
        this.actualReference = actualReference;
    }

    @Override
    public boolean hasNext() {
        return actualReference != null;
    }

    @Override
    public E next() {
        if( hasNext() ){
            E dataRef = actualReference.getData();
            actualReference = actualReference.getPtr();
            return dataRef;
        } else {
            return null;
        }
    }
}