/**
 * Created by dos on 14.11.2016.
 */
public class ClassWithTwoMethods {
    int paint = 123 ;
    String args ="args";
    int lol  = 3;
    ClassWithTwoMethods(){
    }
    ClassWithTwoMethods(int l){
    paint = l;
    }
    ClassWithTwoMethods(int l,String args,int lol){
        this(l);
        this.args = args;
        this.lol = lol;
    }
    public static void main(String[] args){
        ClassWithTwoMethods a= new ClassWithTwoMethods();
        ClassWithTwoMethods b = new ClassWithTwoMethods(123);
        ClassWithTwoMethods c = new ClassWithTwoMethods(23,"kek",56);
        System.out.println( a.getClass() +" " + a.args +" " + a.paint +" "+ a.lol);
        System.out.println( b.getClass() + " " + b.args+" " + b.paint +" "+ b.lol);
        System.out.println(c.getClass() + " " + c.args +" "+ c.paint +" "+ c.lol);
    }
}
