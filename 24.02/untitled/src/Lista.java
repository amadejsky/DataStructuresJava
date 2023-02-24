public class Lista {
    private String Line;
    public Lista(String Line){this.Line=Line;};

    public String ListaProduktow(){
        String Tab[] = Line.split(",");
        StringBuilder str = new StringBuilder();
        for(int i=0;i< Tab.length;i++){
           str.append(i).append(" ").append(Tab[i]);

        }
        return str.toString();
    }
    public String getLineText(){return Line;};
    public void setLineText(String Line){this.Line=Line;};
}
