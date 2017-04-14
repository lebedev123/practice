/**
 * Created by dos on 01.10.2016.
 */
public class main1 {
    static boolean test1(int val) {
        System.out.println("test1 val= " + val);
        return val < 1;
    }
    static boolean test2(int val){
        System.out.println("test2 val= " + val);
        return val < 1;
    }
    static boolean test3(int val){
        System.out.println("test3 val= " + val);
        return val < 1;
    }
    public static void main(String[] args){
        boolean b = test1(0) && test2(2) && test3(3);
        System.out.println(b);
    }
}
