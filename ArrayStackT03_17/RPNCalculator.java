package inter;

import javax.naming.OperationNotSupportedException;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class RPNCalculator
{
    private TArrayStack<Integer> stack;

    public RPNCalculator(int stackSize)
    {
        stack = new TArrayStack<Integer>(stackSize > 126 ? stackSize : 256);
    }

    public int compute(String rpn) throws OperationNotSupportedException, DataFormatException{
        Scanner sc = new Scanner(rpn);
        int result = 0;
        while(sc.hasNext()){
            if(sc.hasNextInt()){
                stack.push(sc.nextInt());
            }else{
                String word= sc.next();
                char sign = word.charAt(0);
                if(operation(sign)){
                    executeOperation(sign);
                }else{
                    throw new OperationNotSupportedException();
                }
            }
        }
        if(!stack.isEmpty())
            result = stack.pop();
        if(!stack.isEmpty())
            throw new DataFormatException();
        return result;
    }

    private void executeOperation(char sign) throws OperationNotSupportedException{
        int a1, a2;
        if(!stack.isEmpty()){
            a2 = stack.pop();
        }else{
            throw new EmptyStackException();
        }
        if(!stack.isEmpty()){
            a1 = stack.pop();
        }else{
            throw new EmptyStackException();
        }

        switch(sign){
            case '+':
                stack.push(a1 + a2);
                return;
            case '-':
                stack.push(a1 - a2);
                return;
            case '*':
                stack.push(a1 * a2);
                return;
            case '/':
                if(a2!=0)
                stack.push(a1 / a2);
                else
                    throw new ArithmeticException();
                return;

            case '%':
                if(a2!=0)
                stack.push(a1 % a2);
                else
                    throw new ArithmeticException();
                return;
            default:
                throw new OperationNotSupportedException();
        }
    }

    private boolean operation(char sign)
    {
        switch (sign)
        {
            case '+':
            case '-':
            case '/':
            case '%':
            case '*': return true;
            default: return false;
        }
    }
}
