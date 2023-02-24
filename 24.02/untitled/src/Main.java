import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Podaj list zakupow ");
        Scanner sc = new Scanner(System.in);
        String tekst = sc.nextLine();
        Shopping shop = new Shopping(tekst);
        boolean stop = false;
        do{
            System.out.println(shop.showShoppingList());
            System.out.println("podaj numer produktu ");
            if(sc.hasNextInt()){
                int num = sc.nextInt();
                shop.mark(num);

            }else{
                break;
            }
        }while(!stop);
        System.out.println("stan po zakupach");
        System.out.println(shop.showShoppingList());
    }
}
