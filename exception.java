import java.util.Scanner;
import java.util.InputMismatchException;
public class exception{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int div = 0;
        int a=0;
        int b=0;
        try{
        a = sc.nextInt();
        b = sc.nextInt();
        div = a/b;
        }
        catch(InputMismatchException e){
            System.out.println("Error Handled " + e);
        }   
        catch (ArithmeticException e) {
            System.out.println("Error handled "+ e);
        }
        System.out.println(div);

    }
}
