import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class fileexception {
    public static void main(String[] args){
        int sum=0;
        int count=0;
        try{
            File file = new File("Numbers.txt");
            Scanner sc = new Scanner(file);
            while(sc.hasNext()){
                int num = sc.nextInt();
                sum+=num;
                count++;
            }
            sc.close();
            double average = (double)sum/count;
            System.out.println("Sum:"+sum);
            System.out.println("Average:"+average);
        }
            catch(FileNotFoundException e){
                System.out.println("Error Handled "+e);
            }
            catch(Exception e){
                System.out.println("Error handled "+e);
            }
        }
    }
    

