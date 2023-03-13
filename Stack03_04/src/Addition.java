import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

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

    public String ExecuteForFile(String filename) throws FileNotFoundException {
        FileInputStream fin = new FileInputStream(filename);
        Scanner sc = new Scanner(fin);

        StringBuilder sb = new StringBuilder();

        try {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(" ");
                if (parts.length != 2) {
                    throw new IllegalArgumentException("Invalid input file format");
                }
                String A = parts[0];
                String B = parts[1];
                String result = Execute(A, B);
                sb.append(result);
            }
        } catch (NoSuchElementException | IllegalStateException e) {
            throw new IllegalArgumentException("Invalid input file format");
        }

        sc.close();

        return sb.toString();
    }
    }


