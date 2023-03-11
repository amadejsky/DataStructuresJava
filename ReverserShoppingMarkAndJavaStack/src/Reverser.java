import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

public class Reverser {
    private String text;

    public Reverser(String text) {
        this.text = text;
    }

    public String Run(){
        String Error = "Invalid Argument";
        String[] tabStr;
        StringBuilder stb = new StringBuilder();
        Stack<String> stackStr = new Stack<>();
        tabStr=text.split(" ");

        System.out.println("Choose the method of displaying reverse text: Stack |or| TemplateString");
        Scanner sc = new Scanner(System.in);
        String option = sc.nextLine();

        if(option.toUpperCase().equals("TEMPLATESTRING")){
            for(int i= tabStr.length-1;i>=0;i--){
                stb.append(tabStr[i]);
            }
            System.out.println(stb.toString());
        }

        if(option.toUpperCase().equals("STACK")){
            for(String word: tabStr )
                stackStr.push(word);
            while(!stackStr.empty())
                System.out.println(stackStr.pop()+" ");

        }



        return Error;
    }
}
