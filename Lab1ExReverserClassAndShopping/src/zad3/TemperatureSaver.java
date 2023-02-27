package zad3;

public class TemperatureSaver {
    private final int Extend_Size = 10;
    private int[] tempTab;
    private int firstEmpty;

    public TemperatureSaver(int size){
        if(size<=0){
            tempTab=new int[10];
        }
        else{
            tempTab = new int[size];
        }
    }

    public void saveValue(int temp){
        if(firstEmpty < tempTab.length){
            tempTab[firstEmpty] = temp;
            firstEmpty++;
        }
        else{
            int[] newTab = new int[tempTab.length+Extend_Size];
            for (int i = 0;i<tempTab.length;i++){
                newTab[i] = tempTab[i];
            }
            tempTab = newTab;
            tempTab[firstEmpty] = temp;
            firstEmpty++;
        }
    }
    public double computeAverage(){
        if(firstEmpty ==0)
            return 0;
        double sum=0;
        for(int i=0;i<firstEmpty;i++){
            sum+=tempTab[i];
        }
        return sum/firstEmpty;

    }

    public String showAll(){
        StringBuilder str = new StringBuilder();
        for(int i = 0;i<firstEmpty;i++){
            str.append(tempTab[i]).append(" ");
        }
        return str.toString();
    }
}
