import java.util.Random;

/**
 * Created by dos on 27.10.2016.
 */
public class Moneta {
    public static void main(String[] args){
        Random random=new Random();
        int j = random.nextInt(2);
        if(j==1) System.out.println("Orel");
        else System.out.println("reshka");
    }
}
