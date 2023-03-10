import java.util.Scanner;

public class Exercise01Lab3 {
    public static void runSolution(String part) {
        Addition add = new Addition();
        if(part.equals("a")){
            String A = "998777777777777";
            String B = "1145999999999999999999999993";
            String result = add.Execute(A,B);
            System.out.println(result);


        }else if(part.equals("b")){
            Scanner sc = new Scanner(System.in);
            System.out.println("Podaj liczbe A ");
            String A = sc.nextLine();
            System.out.println("Podaj liczbe B ");
            String B = sc.nextLine();

            try{
                String result = add.Execute(A,B);
                int length = A.length()>B.length()?A.length():B.length();


            }

        }
    }
}
