import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution2 {
    public static void run(String file){
        try(FileInputStream fin = new FileInputStream(file)){
            Scanner scF = new Scanner(fin);
            while(scF.hasNext()){
                System.out.println(reverseWords(scF.nextLine()));
            }
        }catch (IOException e){
            System.out.println("Exception "+e.toString());
        }
    }

    private static String reverseWords(String line){
        TStack<String> st = new TStack<>();
        String lineReady = line
                .replace('-', ' ')
                .replace(';', ' ')
                .replace(':', ' ')
                .replace(',', ' ');
        Scanner scanner = new Scanner(lineReady);
        while(scanner.hasNext()){
            st.push(scanner.next());
        }
        StringBuilder str = new StringBuilder();
        while ((!st.isEmpty())){
            str.append(st.pop()).append(' ');
        }
        return str.toString();
    }
}
