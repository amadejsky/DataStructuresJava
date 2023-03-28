package inter;

import inter.InterStack;

import java.sql.SQLOutput;
import java.util.EmptyStackException;

public class TArrayStack<E> implements InterStack<E> {
    private int end;
    private int maxSize;
    private int size;
    private E[] memoryStack;

    public TArrayStack(int maxSize) {
        if (maxSize < 1)
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
        if (size == 0) {
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
        if (size == maxSize) {
            throw new StackOverflowError();
        } else if (size == 0) {
            memoryStack[end] = item;
            size++;
        } else {
            end++;
            memoryStack[end] = item;
            size++;
        }
    }

    public void extendMemory() {
        int newMaxSize = (int) Math.round(maxSize * 1.5);
        E[] newTab = (E[]) new Object[newMaxSize];
        System.arraycopy(this.memoryStack, 0, newTab, 0, this.size);
        this.memoryStack = newTab;
        this.maxSize = newMaxSize;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int deepLevel(E item) {
        for (int i = 0; i < memoryStack.length; i++) {
            if (memoryStack[i].equals(item)) {
                System.out.println("Level of element in the stack is: ");
                return i;
            }
        }
        return -1;
        //int deepLevel(item)sprawdzającą ja głęboko na stosie jest dostępny szukany elementitem.
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public String printStack() {
        //String printStack()pozwalającą na wyświetlenie stosu w postacikolejnych elementów tablicy. Przykładowo jeżeli do stosu przekażemy napisy: „ene”, „due”, „rike”, „fake”, to metoda produkuje łańcuch znaków postaci:Tab[3]=fake <-topTab[2]=rikeTab[1]=dueTab[0]=ene
        StringBuilder sb = new StringBuilder();
        if (this.size == 0) {
            return "[EMPTY]";
        } else {
            for (int i = memoryStack.length - 1; i >= 0; i--) {
                sb.append("Tab" + "[" + i + "] " + memoryStack[i] + "\n");
            }
            sb.append("<---top");
        }


        return sb.toString();
    }
}


//    public String printStack() {
//        if (this.size == 0) {
//            return "[]";
//        } else {
//            StringBuilder sb = new StringBuilder();
//
//            for(int i = 0; i < this.size; ++i) {
//                sb.append(String.format("[ %s ]", this.memoryStack[this.size - 1 - i].toString()));
//                if (i == 0) {
//                    sb.append(" <-- ");
//                }
//
//                sb.append("\n");
//            }
//
//            return sb.toString();
//        }
//    }

