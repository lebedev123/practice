/**
 * Created by dos on 17.09.2016.
 */
public class Boo {
    public String name;
    private int Id;
    private static int AllId = 0;
    public Boo(int i){}
    public Boo(String s){}
    public Boo(String s, int a){}
    public void bark(){
        System.out.println("I am Boo");
    }
    public static void shit(Boo m){
        m.bark();
    }
    public String getName(){
        return name;
    }
    public static int getAllId(Boo a){
        return a.AllId;
    }
}
class SonOfBoo extends  Boo{
    public SonOfBoo(){
        super("boo");
    }
    public void bark(){
        System.out.println("I am SonOfBoo");
    }
}
interface BooBoss{
    double bossSalary = 34000;
    default String k(){
        return "ya default method";
    }
}
class Boss implements BooBoss{
    @Override
    public String k() {
        return "gavno";
    }

}
class SonOfSon extends SonOfBoo{
    public void bark(){
        System.out.println("I am SonOfSon");
    }
    public static void main(String[] args) {
        SonOfSon n1 = new SonOfSon();
        Boo n3 = new SonOfBoo();
        Boo n4 = new Boo("SonOfABitch");
        n1.bark();
        System.out.println(Boo.getAllId(n4));
        System.out.println("//////");
        Boo[] heroes = new Boo[2];
        heroes[0] = new Boo(30);
        heroes[1] = new SonOfBoo();
        for(Boo r : heroes){
            r.bark();
        }
        System.out.println("//////");
        n3.bark();
        shit(n1);

        shit(n3);
        Boss b = new Boss();
        System.out.println(b.k());
    }
}
