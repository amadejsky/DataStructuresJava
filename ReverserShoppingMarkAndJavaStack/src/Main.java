import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       //ex1();
        //ex2();
        ex3();
    }


    public static void ex1(){
        System.out.println("Input the text you want to split and reverse: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        Reverser rev = new Reverser(text);
        rev.Run();
    }

    public static void ex2(){
        boolean stop = false;
        System.out.println("Enter the shopping list with products separated with= , ");
        Scanner sc = new Scanner(System.in);
        String shopping = sc.nextLine();
        ShoppingList sh = new ShoppingList(shopping);
        do{
            System.out.println(sh.showList());
            System.out.println("Input the number you want to mark as already bought:");
            if(sc.hasNextInt()){
                int num = sc.nextInt();
                sh.markBought(num);
            }else{
                break;
            }

        }while(!stop);
        System.out.println("after shopping");
        System.out.println(sh.showList());
    }

    public static void ex3(){
        Scanner sc = new Scanner(System.in);
        Temperature temp = new Temperature(5);
        do{
            System.out.println("Enter the integer number of temperature you have measured: ");
            if(sc.hasNextInt()){
                temp.saveTemp(sc.nextInt());
            }else{
                sc.next();
                break;
            }
            System.out.println("Average "+temp.computeAverage());
            System.out.println("All "+temp.showAll());


        }while(true);
    }
}
