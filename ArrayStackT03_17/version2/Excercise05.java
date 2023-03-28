package inter.version2;



import javax.naming.OperationNotSupportedException;
import java.util.zip.DataFormatException;

public class Excercise05
{
    public static void main(String[] args)
    {
        RPNGenerator rpn = new RPNGenerator(256);
        String onp = "2 3 + 10 * 20 4 + 6 / - 13 2 + 7 % + ";
        System.out.println("onp = "+onp);
        try{
            RPNCalculator calc = new RPNCalculator(256);
            int result = calc.compute(onp);
            System.out.println(result);
        } catch (OperationNotSupportedException e){
            e.printStackTrace();
        } catch (DataFormatException e){
            e.printStackTrace();
        }
    }
}
