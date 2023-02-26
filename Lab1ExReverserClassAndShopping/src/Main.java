import zad1.Reverser;
import zad2.Shopping;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //zad1();
        zad2();

    }

    public static void zad1(){
        System.out.println("--------------------------1---------------------------");
        System.out.println("Input the text to view the words in reverse order");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        Reverser re = new Reverser(text);
        System.out.println(re.Reverse());
    }

    public static void zad2(){
        System.out.println("---------------------2------------------------");
        System.out.println("Input your Shopping list here:");
        Scanner sc = new Scanner(System.in);
        String tx = sc.nextLine();
        Shopping sh = new Shopping(tx);
        boolean stop = false;
        do{
            System.out.println(sh.showShoppingList());
            System.out.println("Input the product number that you already bought ");
            if(sc.hasNextInt()){
                int num = sc.nextInt();
                sh.mark(num);
            }else{
                break;
            }
        }while (!stop);
        System.out.println("After the shopping");
        System.out.println(sh.showShoppingList());
    }
}


