import java.io.FileInputStream;
import java.util.EmptyStackException;
import java.util.Scanner;

public class BracketsValidator {

    private TStack<String> dataStack;

    public BracketsValidator() {
        this.dataStack = new TStack<>();
    }

    public boolean readText(String filename){
        try(FileInputStream fin = new FileInputStream(filename)){
            Scanner sc = new Scanner(fin);
            while(sc.hasNext()){
                String next = sc.next();
                for(int i =0;i<next.length();i++){
                    char c = next.charAt(i);
                    dataStack.push(String.valueOf(c));
                }
            }
        }catch(Exception e){
            return false;
        }
        return true;
    }



    public boolean Validate(String filename){
        boolean ok = readText(filename);
        int openBracketsCounter = 0;
        int closedBracketsCounter =0;
        if(ok){
            while(!dataStack.isEmpty()){
                String current = dataStack.pop();
                if(current.equals("(")||current.equals("[")||current.equals("{")){
                    openBracketsCounter++;
                } else if (current.equals(")")||current.equals("]")||current.equals("}")){
                    closedBracketsCounter++;
                }
            }
            if(openBracketsCounter==closedBracketsCounter){
                System.out.println("Ok,brackets are correct!");
                return true;
            }else{
                System.out.println("Error! Brackets are incorrect!");
                return false;
            }

        }
       return false;
    }



}
