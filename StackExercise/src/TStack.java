import java.util.EmptyStackException;

public class TStack<E> implements InterStackE<E> {

    private TStackNode<E> top;

    public TStack(){
        top = null;
    }
    @Override
    public boolean isEmpty() {
        if(top==null)
            return true;
        else
            return false;
    }

    @Override
    public E top() {
        return top.getData();
    }

    @Override
    public E pop() {
        if(top==null)
            throw new EmptyStackException();
        else{
            E ExTop = top.getData();
            top = top.getPrev();
            return ExTop;
        }
    }

    @Override
    public int size() {
        if(top == null){
            return 0;
        }else{
            int counter =0;
            TStackNode refNode = top;
            while(refNode!=null){
                refNode=refNode.getPrev();
                counter++;
            }
            return counter;
        }
    }

    @Override
    public int deepLevel(E item) {
        TStackNode<E> tmp = top;
        int level =0;
        while(tmp!=null){
            if(item==tmp.getData()){
                return level;
            }
            tmp = tmp.getPrev();
            level++;
        }
        return -1;

    }

    public void deleteBottom(){
        TStackNode<E> tmp = top;
        if(top == null)
            throw new EmptyStackException();

        if(tmp.getPrev()==null){
            tmp=null;
        }else{
            while(tmp.getPrev().getPrev()!=null){
                tmp.getPrev();
            }
            tmp.setPrev(null);
        }

    }

    @Override
    public void push(E item) {
        TStackNode<E> newNodeTop = new TStackNode<>(item,top);
        top = newNodeTop;

    }
}
