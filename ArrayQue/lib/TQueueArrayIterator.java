package lib;

import java.util.Iterator;

public class TQueueArrayIterator<E> implements Iterator<E> {
    private int start;
    private int count;
    private E[] arrayReference;
    private int arrayRefSize;

    public TQueueArrayIterator(int start, int count, E[] arrayReference, int arrayRefSize) {
        this.start = start;
        this.count = count;
        this.arrayReference = arrayReference;
        this.arrayRefSize = arrayRefSize;
    }

    @Override
    public boolean hasNext() {
        if( count > 0 )
            return true;
        else
            return false;
    }

    @Override
    public E next() {
        if (hasNext()) {
            E refData = arrayReference[start];
            start = ( start + 1 )%arrayRefSize;
            count--;
            return refData;
        } else {
            return null;
        }
    }
}
