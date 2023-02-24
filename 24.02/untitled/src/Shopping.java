public class Shopping {
    private final String Bought = "kupione";
    private String[] shoppingList;
    public Shopping(String list){shoppingList = list.split(",");};
    public String showShoppingList(){
        StringBuilder str = new StringBuilder();
        for(int i =0;i< shoppingList.length;i++){
            str.append(i+1).append(" ").append(shoppingList[i]);
        }
        return str.toString();
    }

    public void mark(int number){
        if(number <1 || number>shoppingList.length)
            System.out.println("error wrong number");
        else{
            if(!shoppingList[number-1].contains(Bought)){
                shoppingList[number-1]=shoppingList[number-1]+Bought;
            }
        }
    }
}
