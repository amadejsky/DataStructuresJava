import java.util.Scanner;

public class CallExercise  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Addition add = new Addition();
        System.out.println("Podaj wariant a manualny b z pliku");
        String var = sc.nextLine();
        if(var.equals("a")){
            System.out.println("Podaj liczbe a");
            String A = sc.nextLine();
            System.out.println("Podaj liczbe b");
            String B = sc.nextLine();

            try{
                String result = add.Execute(A,B);
                int length = A.length()<B.length()?B.length():A.length();
                if(result.length()>length){
                    length=result.length();
                    System.out.println(String.format("%"+length+"s%n+%n%"+length+"s%n+%ns%",A,B,result));
                }else System.out.println(String.format("%"+length+"s%n+%n%"+length+"s%n+%n%s",A,B,result));

            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(var.equals("b")){
            String result = add.ExecuteForFile("D:\\CodeProjects\\DataStructures\\DataStructuresJava\\Stack03_04\\src\\numbers.txt");
            System.out.println(result);
        }


    }
}
