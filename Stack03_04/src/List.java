import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class List {
    private final String olOpen ="<ol>" ;
    private final String olClose="</ol>" ;
    private final String liOpen="<li>" ;
    private final String liClose="</li>" ;
    private final String endLine ="\r\n" ;
    private final String Tab ="\t" ;

    private TStack<String> stackList;
    private String className;
    public String getClassName(){return className;}

    public void setClassName(String className) {
        this.className = className;
    }

    public List(String className){
        this.stackList=new TStack<String>();
        this.className=className;
    }
    public String generateCode(String fileName){
        if(readDataFromFile(fileName)){
            return createList();
        }else{
            System.out.println("File error!");
            return " ";
        }
    }

    public String createList(){
        StringBuilder str = new StringBuilder(String.format("<ol class=\"%s\">",className));
        str.append(endLine);
        while(!stackList.isEmpty()){
            str.append(Tab).append(liOpen).append(stackList.pop()).append(liClose).append(endLine);
        }
        str.append(olClose).append(endLine);
        return str.toString();
    }

    private boolean readDataFromFile(String filename){
        try(FileInputStream fin = new FileInputStream(filename)){
            Scanner sc = new Scanner(fin);
            while(sc.hasNext()){
                //String line = sc.nextLine();
                stackList.push(sc.nextLine());
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
            return false;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
