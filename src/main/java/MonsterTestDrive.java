/**
 * Created by dos on 08.09.2016.
 */
public class MonsterTestDrive {
    public static void main (String[] args){
        Monster[] ma = new Monster[3];
        ma[0]= new Vampire();
        ma[1] = new Dragon();
        ma[2]= new Monster();
        for(int x = 0;x<3;x++){
            ma[x].frighten(x);
        }
    }
}
class Monster{
    boolean frighten(int x){
        System.out.println("Grrrr");
        return true;
    }


}
class Vampire extends Monster{
    boolean frighten(int x){
        System.out.println("Ykysit?");
        return true;
    }
}
class Dragon extends  Monster{
    boolean frighten(int degree){
        System.out.println("Огненное дыхание");
        return true;
    }
}