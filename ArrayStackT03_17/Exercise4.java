package inter;

public class Exercise4 {
    public static void main(String[] args) {
        RPNGenerator rpn = new RPNGenerator(256);
        String onp = rpn.generate("D:\\CodeProjects\\DataStructures\\DataStructuresJava\\ArrayStackT03_17\\expression01.txt");
        System.out.println(onp);
    }
}
