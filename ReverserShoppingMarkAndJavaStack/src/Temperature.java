public class Temperature {
    private int [] tabTemp;
    private int extend = 10;
    private int firstEmpty;

    public Temperature(int n){
        if(n>=0)
            tabTemp=new int[10];
        else
            tabTemp = new int[n];

    }

    public void saveTemp(int n){
        if(firstEmpty < tabTemp.length){
            tabTemp[firstEmpty]=n;
            firstEmpty++;
        }
        else{
            int[] tabExt = new int[tabTemp.length+extend];
            for(int i=0;i<tabTemp.length;i++){
                tabExt[i]=tabTemp[i];
            }
            tabTemp = tabExt;
            tabTemp[firstEmpty] = n;
            firstEmpty++;

        }
    }

    public double computeAverage(){
        int sum=0;
        if(firstEmpty==0)
            return 0;
        else {
            for (int i = 0; i < tabTemp.length; i++) {
                sum += tabTemp[i];
            }
            double average = (double) sum /firstEmpty;
            return average;
        }
    }

    public String showAll(){
        StringBuilder str = new StringBuilder();
        for(int i=0;i<tabTemp.length;i++){
            str.append(tabTemp[i]);
        }
        return str.toString();
    }



    }
