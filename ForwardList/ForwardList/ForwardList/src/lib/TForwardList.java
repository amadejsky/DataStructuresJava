package lib;

import lib.base.InterForwardList;

public class TForwardList<E> implements InterForwardList<E> {
    private TForwardListNode<E> first;
    @Override
    public int size() {
        var ref = first;
        int counter = 0;
        while( ref != null ){
            counter++;
            ref = ref.getNext();
        }
        return counter;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean addFirst(E e) {
        return false;
    }

    @Override
    public boolean add(E e) {
        if( e == null )
            return false;
        if( isEmpty() ){
            first = new TForwardListNode<>(e);
        } else {
            var ref = first;
            while( ref.getNext()!= null ){
                ref = ref.getNext();
            }
            ref.setNext(new TForwardListNode<>(e));
        }
        return true;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public void clear() {

    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E remove(int index) {
        if( index < 0 )
            throw new IndexOutOfBoundsException();
        if( first == null ) {
            return null;
        } else if( index == 0 ) {
            var ref = first;
            first = first.getNext();
            return ref.getData();
        } else {
            var ref = first;
//            int nodeIndex = 0;
//            while (nodeIndex < index - 1) {
//                nodeIndex++;
//                if( ref.getNext() == null ) {
//                    throw new IndexOutOfBoundsException();
//                } else {
//                    ref = ref.getNext();
//                }
//            }
            for (int i = 0; i < index - 1; i++) {
                if( ref.getNext() == null ) {
                    throw new IndexOutOfBoundsException();
                } else {
                    ref = ref.getNext();
                }
            }

            if(ref.getNext() != null){
                var data = ref.getNext().getData();
                ref.setNext(ref.getNext().getNext());
                return data;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        if( index < 0 )
            throw new IndexOutOfBoundsException();
        if( first == null ){
            return null;
        } else {
            int indexNode = 0;
            E searchingElementNode;
            var ref = first;
            while( indexNode < index/*-1*/){ //dodałem
               ref = ref.getNext();
               indexNode++; // dodałem
               if( ref == null )
                   throw new IndexOutOfBoundsException();
            }
            searchingElementNode = ref.getData();
            ref.setData(element);
            return searchingElementNode;
        }
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }
}
