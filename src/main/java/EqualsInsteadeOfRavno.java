/**
 * Created by dos on 11.12.2016.
 */
public class EqualsInsteadeOfRavno {
    public static void main(String ... args){
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        EqualsInsteadeOfRavno a1 = new EqualsInsteadeOfRavno();
        EqualsInsteadeOfRavno b1 = new EqualsInsteadeOfRavno();
        EqualsInsteadeOfRavno c1 = new EqualsInsteadeOfRavno();

        if(a.equals(b)) System.out.println("A equals b");
        else System.out.println("a not equals b");
        if(a.equals(c)) System.out.println("A equals c");
        else System.out.println("a not equals c");
        if(a == b) System.out.println("a == b");
        else System.out.println("a != b");
        if(a == c) System.out.println("a == c");
        else System.out.println("a != c");
        System.out.println(a1);
        System.out.println(b1);
        System.out.println(c1);
    }
}
