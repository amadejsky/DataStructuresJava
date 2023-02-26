package zad1;

public class Reverser {
    private String text;

    public Reverser(String text) {
        this.text = text;
    }
    //method
    public String Reverse(){
        String[] tabRev = text.split(" ");
        StringBuilder str = new StringBuilder();
        for(int i = tabRev.length-1;i>=0;i--){
            str.append(tabRev[i]).append(" ");
        }
        return str.toString();

    }
//    public String getLineText() {return text;};
//
//    public void setText(String text) {
//        this.text = text;
//    }
}
