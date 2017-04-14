/**
 * Created by dos on 21.07.2016.
 */
public class GuessGame {
    Player p1;
    Player p2;
    Player p3;

    public  void startGame(){
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        int guessp1 = 0;
        int guessp2=0;
        int guessp3 = 0;
        boolean p1isRight = false;
        boolean p2isRight = false;
        boolean p3isRight = false;
        int target ;//(int)(Math.random()*10);
         target = 1;
        System.out.println("I guess a number from 0 to 9");
        while(true){
            System.out.println("That number is "+target);

            p1.guess();
            p2.guess();
            p3.guess();

            System.out.println("First player thinks that this number is "+p1.number);
            System.out.println("Second player thinks that this number is "+p2.number);
            System.out.println("Third player thinks that this number is "+p3.number);
            if (p1.number == target){
                p1isRight = true;
                System.out.print("First player was right");
                break;
            }else
            if(p2.number==target){
                p2isRight=true;
                System.out.println("Second player was right");
                break;
            }else
            if (p3.number==target){
                p3isRight=true;
                System.out.println("Third player was right");
                break;
            }else{
                System.out.println("Nobody was right,lets try again");
            }
        }
    }
}
