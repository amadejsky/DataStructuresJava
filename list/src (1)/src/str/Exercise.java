package str;

public class Exercise {
    public static void main(String[] args) {
        TForwardList<Integer> listInt;
        listInt = new TForwardList<Integer>();

        System.out.println("Adding element of list");
        for(int i=1;i<20;i++){
            if(i%2==0)
                listInt.add(i);
        }

        System.out.println(String.format("Dlugosc listy: %d",listInt.size()));

        System.out.println("b) Zerowanie wybranych elementow list");
        int listSize = listInt.size();
        Integer deletedInt;
        for(int i=0;i<listSize ;i++){
            if(i%2==1){
                deletedInt = listInt.set(i,0);
                System.out.println(String.format("Wyzerowano %d",deletedInt));
            }
        }

        while(!listInt.isEmpty()){
            listInt.remove(0);
        }
        System.out.println(listInt.size());

        long start = System.currentTimeMillis();
        long a=0;
//        for(int j=0;j<10000;j++){
//            a+=1;
//        }
        TForwardList<Integer> list2 = new TForwardList<>();
        for(int j=0;j<10000;j++){
            list2.add(j);
        }
        long stop = System.currentTimeMillis();
        System.out.println(String.format("Czas wykonania:%d ms",stop-start));

    }
}
