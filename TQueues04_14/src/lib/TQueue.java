package lib;

import inter.InterQueueIterable;

import java.util.Iterator;

public class TQueue<E> implements InterQueueIterable<E> {
    private TQueueNode<E> head;
    private TQueueNode<E> tail;

    public TQueue() {
        head = null;
        tail = null;
    }

    @Override
    public boolean put(E element) {
        TQueueNode<E> ref;
        try {
            ref = new TQueueNode<E>(element);
        } catch (Exception e) {
            return false;
        }
        if( head == null ){
            head = ref;
            tail = ref;
        } else {
            tail.setPtr( ref );
            tail = tail.getPtr();
        }
        return true;
    }

    @Override
    public E top() {
//        if( head == null )
//            return null;
//        else
//            return head.getData();
        return head == null ? null : head.getData();
    }

    @Override
    public E get() {
        if (head == null) {
            return null;
        } else if ( head.getPtr() == null ) { //FIXME: refactor
            E dataRef = head.getData();
            head = null;
            tail = null;
            return dataRef;
        } else {
            E dataRef = head.getData();
            head = head.getPtr();
            return dataRef;
        }
    }

    @Override
    public boolean pop() {
        return false;
    }

    @Override
    public boolean isEmpty() {
//        if (head == null) {
//            return false;
//        } else {
//            return true;
//        }
//        return head == null ? true: false;
        return head == null;
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        int count = 0;
        TQueueNode<E> current = head;
        while (current != null) {
            count++;
            current = current.getPtr();
        }
        return count;
    }

    public boolean switchHeadTail() {
        if (head == null || head == tail) {
            return false;
        } else {
            TQueueNode<E> prev = null;
            TQueueNode<E> curr = head;
            while (curr.getPtr() != null) {
                prev = curr;
                curr = curr.getPtr();
            }
            // głowa z ogonem
            tail.setPtr(head.getPtr());
            head.setPtr(null);
            prev.setPtr(head);
            //  zmienne head i tail
            TQueueNode<E> temp = head;
            head = tail;
            tail = temp;
            return true;
        }
    }
    public void join(E[] elements) {
        for (E element : elements) {
            put(element);
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        TQueueIterator<E> iterator = new TQueueIterator<>(head);
        while (iterator.hasNext()) {
            sb.append(iterator.next().toString());
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new TQueueIterator<E>(head);
    }
}