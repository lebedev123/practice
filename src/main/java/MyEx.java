import java.util.Scanner;

/**
 * Created by dos on 28.09.2016.
 */
public class MyEx extends Exception {
}

 class ExTestDrive {
    static void doRisky(String t)throws MyEx{
        System.out.print("h");
        if("yes".equals(t)){
            throw new MyEx();
        }
    }
public static void main(String[] args ){
    Scanner e = new Scanner(System.in);
    String st = e.next();
    String test = "no";
    System.out.print("t");
    try{
        doRisky(test);
        System.out.print("r");
        System.out.print("o");
    }catch(MyEx ex){
        System.out.print("a");
    }
    System.out.print("w");
    System.out.print("s");

}}
