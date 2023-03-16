import java.io.FileNotFoundException;

public class Program {
    public static void main(String[] args) {
        //Solution.partA();
        //Solution2.run("D:\\CodeProjects\\DataStructures\\DataStructuresJava\\Stack03_04\\src\\morsztyn.txt");
        //ReverseLineExercise.run("D:\\\\CodeProjects\\\\DataStructures\\\\DataStructuresJava\\\\Stack03_04\\\\src\\\\kochanowski.txt");
    try{
        Exercise01Lab3.runSolution("c");
    }catch(FileNotFoundException e){
        e.printStackTrace();
        System.out.println("File not found");
        }
    }

}
