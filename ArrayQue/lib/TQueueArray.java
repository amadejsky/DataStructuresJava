package lib;

import inter.InterQueueIterable;

import java.util.Iterator;

public class TQueueArray<E> implements InterQueueIterable<E> {
    private int head;
    private int tail;
    private int size;
    final private int maxSize;
    private E[] array;

    public TQueueArray(int maxSize) {
        this.maxSize = maxSize > 1 ? maxSize : 256;
        head = 0;
        tail = 0;
        size = 0;
        array = (E[]) new Object[this.maxSize];
    }

    @Override
    public boolean put(E element) { //todo: refactoring
        if( isEmpty() ){
            array[tail] = element;
            size++;
            return true;
        } else if ( isFull() ) {
            return false;
        } else {
            tail = ( tail + 1 ) % maxSize;
            array[tail] = element;
            size++;
            return true;
        }
    }
    public boolean putFront(E element) {
        if (isEmpty()) {
            array[head] = element;
            size++;
            return true;
        } else if (isFull()) {
            return false;
        } else {
            head = head == 0 ? maxSize - 1 : head - 1;
            array[head] = element;
            size++;
            return true;
        }
    }

    @Override
    public E top() {
        if( size > 0 ) {
            return array[head];
        } else {
            return null;
        }
    }

    @Override
    public E get() {
        if (isEmpty()) {
            return null;
        } else {
            E element = array[head];
            array[head] = null;
            head = (head + 1) % maxSize;
            size--;
            return element;
        }
    }

    public E getBack() {
        if (isEmpty()) {
            return null;
        } else {
            E element = array[tail];
            array[tail] = null;
            tail = tail == 0 ? maxSize - 1 : tail - 1;
            size--;
            return element;
        }
    }

    @Override
    public boolean pop() {
        if( isEmpty() ) {
            return false;
        } else if ( size == 1 ) {
            head = 0;
            tail = 0;
            size = 0;
            return true;
        } else {
            head = ( head + 1 ) % maxSize;
            size--;
            return true;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return  size == maxSize;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new TQueueArrayIterator<E>(head,size,array,maxSize);
    }

}
