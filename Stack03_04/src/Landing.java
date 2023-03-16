public class Landing {
    public static void main(String[] args) {
        List li = new List("shoppingListBro");
        String output = li.generateCode("D:\\CodeProjects\\DataStructures\\DataStructuresJava\\Stack03_04\\src\\shoppingList.txt");
        System.out.println(output);
    }
}
