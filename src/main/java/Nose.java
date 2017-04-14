

/**
 * Created by dos on 11.09.2016.
 */
public interface Nose {
    public int Method();
}
 class Picasso implements Nose{
    public Picasso(){
        System.out.println("Picasso");
    }
    public Picasso(int a, String b){
        System.out.println(a+b);
    }
    public int Method() {
        return 7;
    }
}
class Clowns extends Picasso{
    public Clowns(){
        System.out.println("Clowns");
    }
}

class Acts implements Nose{
    public Acts() {
        System.out.println("Acts");
    }
    public int Method() {
        return 5;
    }
}
class Of76 extends Clowns{
    public Of76(){
        System.out.println("Of76");
    }
    public String oString(){
        return "gigalul";
    }
    public static void main(String[] args){

        Nose[] i = new Nose[3];
        i[0]= new Acts();
        i[1] = new Clowns();
        i[2]= new Of76();
        for(int x=0;x<3;x++){
            System.out.println(i[x].Method() + " " + i[x].getClass() );
        }
    }
}