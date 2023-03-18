package lib;

import inter.InterStack;

import java.util.EmptyStackException;

public class TArrayStack<E> implements InterStack<E> {
    private int end;
    private int maxSize;
    private int size;
    private E[] memoryStack;

        public TArrayStack(int maxSize) {
        if( maxSize < 1 )
            this.maxSize = 16;
        else
            this.maxSize = maxSize;
        memoryStack = (E[]) new Object[this.maxSize];
        end = 0;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E top() {
        if( size == 0 ) {
            throw new EmptyStackException();
        } else {
            return memoryStack[end];
        }
    }

    @Override
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        } else {
            if (end != 0)
                end--;
            size--;
            return memoryStack[size];
        }
    }

    @Override
    public void push(E item) {
        if( size == maxSize ) {
            throw new StackOverflowError();
        } else if ( size == 0 ) {
            memoryStack[end] = item;
            size++;
        } else {
            end++;
            memoryStack[end] = item;
            size++;
        }
    }

    public void extendMemory(){
            int newMaxSize = (int) Math.round(maxSize*1.5);
            E[] newTab = (E[]) new Object[newMaxSize];
            System.arraycopy(this.memoryStack,0,newTab,0,this.size);
            this.memoryStack=newTab;
            this.maxSize=newMaxSize;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int deepLevel(E item) {
        return 0;
        //TODO int deepLevel(item)sprawdzającą ja głęboko na stosie jest dostępny szukany elementitem.
    }

    public boolean isFull(){
        return size == maxSize;
    }

    public String printStack(){
            //todo String printStack()pozwalającą na wyświetlenie stosu w postacikolejnych elementów tablicy. Przykładowo jeżeli do stosu przekażemy napisy: „ene”, „due”, „rike”, „fake”, to metoda produkuje łańcuch znaków postaci:Tab[3]=fake <-topTab[2]=rikeTab[1]=dueTab[0]=ene
        return "";
    }
}
