import java.util.NoSuchElementException;

public class Addition {
    private TStack<Integer> stA;
    private TStack<Integer> stB;
    private TStack<Integer> stResult;

    public Addition(){
        stA = new TStack<Integer>();
        stB = new TStack<>();
        stResult = new TStack<Integer>();
    }

    private boolean pushToStack(TStack<Integer> stack, String number){
        if(stack==null||number.isEmpty()||number.trim().isEmpty()){
            return false;
        }else{
            for (Character sign : number.toCharArray()){
                if(Character.isDigit(sign)){
                    stack.push(Character.getNumericValue(sign));
                }else{
                    throw new IllegalArgumentException();
                }
            }
            return true;
        }
    }

    public String Execute(String A,String B){
        boolean okA = pushToStack(stA,A);
        boolean okB = pushToStack(stB,B);

        if(okA&&okB) {
            int carry = 0;
            int localSum;
            while (!stA.isEmpty() && !stB.isEmpty()) {
                localSum = stA.pop() + stB.pop() + carry;
                stResult.push(localSum % 10);
                carry = localSum / 10;
            }
            TStack<Integer> rest = stA.isEmpty() ? stB : stA;
            if (!rest.isEmpty()) {
                stResult.push(carry + rest.pop());
                while (!rest.isEmpty()) {
                    stResult.push(rest.pop());
                }
            } else {
                if (carry != 0)
                    stResult.push(carry);
            }
            StringBuilder str = new StringBuilder();
            while (!stResult.isEmpty()) {
                str.append(stResult.pop());
            }
            return str.toString();
        }
            else{
                throw new NoSuchElementException();
            }
        }
    }


