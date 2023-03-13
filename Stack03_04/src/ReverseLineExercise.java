import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReverseLineExercise {
    public static void run(String file){
        try(FileInputStream fin = new FileInputStream(file)) {
            Scanner scn = new Scanner(fin);
            while(scn.hasNext()){
                System.out.println(reverse(scn.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String reverse(String file){
        TStack<String> stackS = new TStack<>();
        String modifiedText = file.replace(","," ")
                .replace(";"," ")
                .replace(":"," ")
                .replace("-"," ");
        Scanner sc = new Scanner(modifiedText);
        while(sc.hasNext()){
            stackS.push(sc.next());
        }
        StringBuilder stB = new StringBuilder();
        while(!stackS.isEmpty()){
            stB.append(stackS.pop()).append(" ");
        }
        return stB.toString();
    }
}
