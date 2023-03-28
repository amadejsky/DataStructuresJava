package inter.version2;

import inter.TArrayStack;

import javax.naming.OperationNotSupportedException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class RPNGenerator
{
    private TArrayStack<Character> stack;
    private StringBuilder str;

    public RPNGenerator(int stackSize){
        stack = new TArrayStack<Character>(stackSize > 126 ? stackSize : 256);
        str = new StringBuilder();
    }

    public String generate(String fileName)
    {
        str.setLength(0);
        try(FileInputStream fin = new FileInputStream(fileName)){
            Scanner scanner = new Scanner(fin);
            while(scanner.hasNext()){
                String word = scanner.next();
                char sign = word.charAt(0);
                if(sign == '('){
                    stack.push(sign);
                }else if(sign == ')'){
                    removeUntillBracker();
                }else if(numberOrVariable(sign)){
                    str.append(word).append(" ");
                } else if (operation(sign)){
                    pushOperationToStack(sign);
                }else {
                    throw new DataFormatException();
                }
            }
            while(!stack.isEmpty()){
                str.append((stack.pop())).append(" ");
            }
            return str.toString();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (DataFormatException e){
            e.printStackTrace();
        } catch (OperationNotSupportedException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return "err";
    }

    private void pushOperationToStack(char sign) throws OperationNotSupportedException
    {
        while( !stack.isEmpty()){
            if(priority(sign) > priority(stack.top())){
                stack.push(sign);
                return;
            }else{
                str.append(stack.pop()).append(" ");
            }
        }
        stack.push(sign);
    }

    private int priority(char sign) throws OperationNotSupportedException
    {
        switch (sign)
        {
            case '(': return 0;
            case '+':
            case '-':
            case ')': return 1;
            case '*':
            case '/':
            case '%': return 2;
            default: throw new OperationNotSupportedException();
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

    private boolean numberOrVariable(char sign)
    {
        if( Character.isLetter(sign) || Character.isDigit(sign))
            return true;
        else
            return false;
    }

    private void removeUntillBracker() throws DataFormatException
    {
        while( !stack.isEmpty() ){
            if( stack.top() == '(' ){
                stack.pop();
                return;
            }else{
                str.append(stack.pop()).append(" ");
            }
        }
        throw new DataFormatException();
    }
}
