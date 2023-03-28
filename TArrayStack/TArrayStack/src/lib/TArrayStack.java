package lib;

import lib.base.InterArrayStack;

import java.util.EmptyStackException;

public class TArrayStack<E> implements InterArrayStack<E> {

    protected final int DEFAULT_MAX_SIZE = 16;
    protected int end;
    protected final int maxSize;
    protected int size;
    protected E[] memoryStack;

    public TArrayStack(int maxSize) {
        if( maxSize > 0 )
            this.maxSize = maxSize;
        else
            this.maxSize = DEFAULT_MAX_SIZE;
        memoryStack = (E[]) new Object[this.maxSize];
        end = 0;
        size = 0;
    }

    @Override
    public boolean isFull() {
        return maxSize == size;
    }

    @Override
    public String printStack() {
        if( size == 0 ){
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append( String.format("[ %s ]", memoryStack[size-1-i].toString()) );
                if( i == 0 )
                    sb.append( " <-- " );
                sb.append( "\n" );
            }
            return sb.toString();
        }
    }

    @Override
    public E top() {
        if( isEmpty() ){
            throw new EmptyStackException();
        } else {
            return memoryStack[end];
        }
    }

    @Override
    public E pop() {
        if( isEmpty() ){
            throw new EmptyStackException();
        } else {
            E item = memoryStack[end];
            memoryStack[end] = null;
            if( end != 0 )
                end--;
            size--;
            return item;
        }
    }

    @Override
    public void push(E item) {
        if( isFull() ){
            throw new StackOverflowError();
        } else {
            if( size != 0 )
                end++;
            memoryStack[end] = item;
            size++;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int deepLevel(E item) {
        return 0;
    }

    @Override
    public String toString() {
        return printStack();
    }
}
