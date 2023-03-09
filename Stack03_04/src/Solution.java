import java.util.Scanner;

    public class Solution{

        public static void run(){
            TStack<String> stackOfBooks =
                    new TStack<>();
            try{
                loadData(stackOfBooks,5);
            }catch(Exception e){
                System.out.println("Wyjatek "+e.getMessage());
                e.printStackTrace();
                return;
            }

            System.out.println("ksiazki od ostatniej ");
            while(!stackOfBooks.isEmpty()){
                System.out.println(stackOfBooks.pop()); //zdejmuje elementy
            }
        }
        private static void loadData(TStack<String> stack,int n){
            if(stack == null){
                throw new NullPointerException();
            }
            Scanner sc = new Scanner(System.in);
            System.out.println(String.format("Podaj %d ksiazek w kolej liniach",n));
            String tmp;
            for(int i=1;i<=n;i++){
                System.out.print(String.format("Podaj pozycje (%d/%d) ksiazek w kolejnych liniach:",i,n));
                tmp = sc.nextLine();
                stack.push(tmp);
            }

        }

        public static void partA(){
            TStack<Integer> st =
                    new TStack<>();
            int num =23;
            System.out.println("spradzamy elementy "+ num);
            System.out.println("stos pusty");
            System.out.println("glebokosc "+num+st.deepLevel(num));
            st.push(5);
            st.push(10);
            st.push(15);
            System.out.println("stos niepusty brak leementu "+num+st.deepLevel(num));
            st.push(23);
            st.push(100);
            st.push(-1);
            System.out.println("stos niepusty szukany");


            while(!st.isEmpty()){
                System.out.println(st.pop());
            }
        }

}
