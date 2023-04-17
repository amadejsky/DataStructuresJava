package str;

import java.util.ArrayList;
import java.util.LinkedList;

public class Exercise04 {

    public static void solution(){
        //int scenarios = 1200;
        //int scenarios = 200;
        int scenarios = 60;
        LinkedList<Double> listLinkedList = new LinkedList<>();
        TForwardList<Double> listTForwardList = new TForwardList<>();
        ArrayList<Double> listArrayList = new ArrayList<>();

        DataInfo dataL = new DataInfo("LinkedList<Double>",scenarios);
        DataInfo dataT = new DataInfo("TForwardList<Double>",scenarios);
        DataInfo dataA = new DataInfo("ArrayList<Double>",scenarios);

        long start,stop;

        for(int i=1;i<=scenarios;i++){
            start = System.currentTimeMillis();
            for(int j=0;j<i*10;j++){
                listLinkedList.add(3.1415);
            }
            stop = System.currentTimeMillis();
            dataL.tab[i-1]=stop-start;
            listLinkedList.clear();
        }
        for(int i =1;i<=scenarios;i++){
            start=System.currentTimeMillis();
            for(int j=0;j<i*10;j++){
                listTForwardList.add(3.1516);
            }
            stop = System.currentTimeMillis();
            dataT.tab[i-1]=stop-start;
            listTForwardList.clear();
        }
        for(int i =1;i<=scenarios;i++){
            start=System.currentTimeMillis();
            for(int j=0;j<i*10;j++){
                listArrayList.add(3.1516);
            }
            stop = System.currentTimeMillis();
            dataA.tab[i-1]=stop-start;
            listArrayList.clear();
        }

        printResults(new DataInfo[]{dataL,dataT,dataA});

    }
    private static void printResults(DataInfo[] dataInfos){
        StringBuilder str;
        for(DataInfo item: dataInfos){
            str = new StringBuilder();
            str.append(item.name).append(": ");
            for(long data: item.tab){
                str.append(data).append('\t');
            }
            System.out.println(str);
        }
    }
}
