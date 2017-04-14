/**
 * Created by dos on 05.01.2017.
 */
public  class Fry{
    private String fName;
    private String lName;
    private final int pr;
    private static int count = 0;
    public Fry(String first,String last,int pr){
        this.pr = pr;
        fName = first;
        lName = last;
        count++;
    }
    public String getfName(){
        return fName;
    }
    public String getlName(){
        return lName;
    }
    public static int getCount(){
        return count;
    }

}
class Bender{
    public static void main(String[] args) {
        Fry pers1 = new Fry("Ostap","Bender",3);
        Fry pers2 = new Fry("Ostap","Bender",4);
        Fry pers3 = new Fry("Ostap","Bender",5);
        System.out.println(pers1.getfName());
        System.out.println(pers1.getlName());
        System.out.println(Fry.getCount());
    }
}
