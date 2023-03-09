import java.util.Scanner;

public class ShoppingList {

    private String[] shoppingTab;
    Scanner sc = new Scanner(System.in);

    public final String marked ="|Bought|";

    public ShoppingList(String list) {
        shoppingTab = list.split(",");
    }


    public String showList(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<shoppingTab.length;i++){
            sb.append(i+1).append(" ").append(shoppingTab[i]).append(" ");
        }
        return sb.toString();
    }
    public void markBought(int num){
        if(num<0||num>shoppingTab.length)
            System.out.println("Wrong number");
        else{
            if(!shoppingTab[num-1].contains(marked)){
                shoppingTab[num-1]=shoppingTab[num-1]+marked;
            }
        }
    }

}
