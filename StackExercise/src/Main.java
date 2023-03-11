import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Run1();
    }



    public static void Run1(){
        TStack<String> bookStack = new TStack<>();
        try{
            loadData(bookStack,7);
        }catch(Exception e){
            System.out.println("Exception "+e.getMessage());
            e.printStackTrace();
            return;
        }

        System.out.println("Book list from the last: ");
        while(!bookStack.isEmpty()){
            System.out.println(bookStack.pop());
        }

    }

    public static void loadData(TStack<String> stack,int n){
        if(stack==null){
            throw new NullPointerException();
        }
        Scanner sc = new Scanner(System.in);
        String tmp;
        for(int i=0;i<=n;i++){
            System.out.println(String.format("Insert %d/%d book: ",i,n));
            tmp = sc.nextLine();
            stack.push(tmp);
        }
    }
}
