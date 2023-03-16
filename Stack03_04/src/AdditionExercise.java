import java.io.FileInputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AdditionExercise {
    private TStack<Integer> stA;
    private TStack<Integer> stB;
    private TStack<Integer> result;
    public AdditionExercise(){
        stA = new TStack<Integer>();
        stB = new TStack<Integer>();
        result = new TStack<Integer>();
    }

    public boolean pushToStack(TStack<Integer> stack, String number){
        if(stack.isEmpty()||number.isEmpty()||number.trim().isEmpty()){
            return false;
        }else{
            for(Character n:number.toCharArray()){
                if(Character.isDigit(n))
                stack.push(Character.getNumericValue(n));
                else
                    throw new IllegalArgumentException();
            }
            return true;
        }
    }

    public String Execute(String A,String B){
        boolean okA = pushToStack(stA,A);
        boolean okB = pushToStack(stB,B);

        if(okA&&okB){
            int carry = 0;
            int localSum =0;
            while(!stA.isEmpty()&&!stB.isEmpty()){
                localSum=stA.pop()+ stB.pop()+carry;
                result.push(localSum%10);
                carry=carry/10;
            }
            TStack<Integer> rest = stA.isEmpty() ? stB:stA;
            if(!rest.isEmpty()){
                result.push(carry+rest.pop());
                while(!rest.isEmpty()){
                    result.push(rest.pop());
                }
            }else{
                if(carry!=0)
                    result.push(carry);

            }
            StringBuilder str = new StringBuilder();
            while(!result.isEmpty()){
                str.append(result.pop());
            }
            return str.toString();

        }else{
            throw new NoSuchElementException();
        }
    }

    public String ExecuteFromFile(String filename){
        try(FileInputStream fin = new FileInputStream(filename)){
            Scanner sc = new Scanner(fin);
            String A = sc.nextLine();
            while(sc.hasNext()){
                A = Execute(A,sc.nextLine());
            }
            return A;

        }catch (Exception e){
            e.printStackTrace();
        }

        return " ";

    }
}
