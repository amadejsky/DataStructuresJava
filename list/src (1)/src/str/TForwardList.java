package str;

import inter.InterForwardList;

import java.util.EmptyStackException;

public class TForwardList<E> implements InterForwardList<E> {

    private TForwardListNode first;

    public TForwardList() {
        first = null;
    }

    @Override
    public int size() {
        if( first == null )
            return 0;
        else {
            TForwardListNode<E> tmp = first;
            int count = 0;
            while (tmp != null){
                count++;
                tmp = tmp.next;
            }
            return count;
        }
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean addFirst(E e) {
       TForwardListNode<E> tmp;
       try{
           tmp = new TForwardListNode<>(e);
       }catch (Exception ex){
           return false;
       }
       if(first == null){
           first = tmp;
       }else{
           tmp.next=first;
           first=tmp;
       }
       return true;
    }

    @Override
    public boolean add(E e) {
        if( first == null ){
            try{
                first = new TForwardListNode(e);
            }
            catch(Exception ex){
                return false;
            }
        }
        else{
            TForwardListNode<E> ptr = first;
            while(ptr.next != null){
                ptr = ptr.next;
            }
            try{
                ptr.next = new TForwardListNode(e);
            }catch(Exception ex){
                return false;
            }
        }
        return true;
    }

    @Override
    public void add(int index, E element) {
        if(first==null)
            throw new IndexOutOfBoundsException();
        else{
            TForwardListNode<E> ref = first;
            int ind=0;
            while(ref!=null){
                if(ind==index-1){
                    TForwardListNode<E> tmp = new TForwardListNode<>(element);
                    tmp.setNext(ref.getNext());
                    ref.setNext(tmp);
                    return;
                }else{
                    ind++;
                    ref = ref.next;
                }
            }
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void clear() {
        first=null;

    }

    @Override
    public E removeFirst() {
        if(first==null){
            return null;
        }else{
            TForwardListNode<E> tmp =first;
            first=first.next;
            return tmp.data;
        }
    }

    @Override
    public E removeLast() {
        if(first==null){
            return null;
        }
        TForwardListNode<E> tmp = first;
        if(first.getNext()==null){
            first = null;
            return tmp.getData();
        }else{
            while(tmp.getNext().getNext()!=null){
                tmp=tmp.getNext();
            }
            E value = tmp.getNext().getData();
            tmp.setNext(null);
            return value;
        }
    }

    @Override
    public E remove(int index) {
        if( first == null ){
            return null;
        }
        TForwardListNode<E> ref = first;
        if( index == 0 ) {
            first = ref.next;
            return ref.data;
        } else {
            int ind = 0;

            while(ref.next != null){
                if( ind == index - 1 ){
                    return deleteNextNode(ref);
                }
                else {
                    ref = ref.next;
                    ind++;
                }
            }
        }
        return null;
    }

    private E deleteNextNode( TForwardListNode<E> ref) {
        TForwardListNode<E> refRev = ref.next;
        ref.next = refRev.next;
        return refRev.data;
    }

    @Override
    public E get(int index) {

        if(first==null)
            return null;
        TForwardListNode<E> tmp = first;
        int ind=0;
        while(tmp!=null){
            if(ind==index){
                return tmp.getData();
            }else{
                tmp=tmp.getNext();
                ind++;
            }
        }
        return null;
    }

    @Override
    public E set(int index, E element) {
        if( first == null ){
            return null;
        }else{
            int ind = 0;
            E tmp;
            TForwardListNode<E> ref = first;
            while(ref != null){
                if(ind == index){
                    tmp = ref.data;
                    ref.data = element;
                    return tmp;
                }else{
                    ref = ref.next;
                    ind++;
                }
            }
        }
        return null;
    }

    @Override
    public int indexOf(E element) {
        TForwardListNode<E> tmp = first;
        int ind=0;
        while(tmp!=null){
            if(tmp.getData().equals(element)){
                return ind;
            }
            ind++;
            tmp=tmp.getNext();
        }
        return -1;
    }
}
