import java.util.Objects;

/**
 * Created by dos on 01.11.2016.
 */
public class EqualsTest {
    int x ;
    public static void lul(String top1,String top2){
        if(top1 == top2)System.out.println("equlas");
        else System.out.println("not equals");
        if (top1.equals(top2))System.out.println("equlas proverka");
        else System.out.println("not equals provarka");
        }
    public static void main(String[] args){
        String new1 = new String("topk3k");
        String new2 = new String("topk3k");
        String new3 = new String("Lul");
        lul(new1,new2);
        lul(new1,new3);
    }
}
