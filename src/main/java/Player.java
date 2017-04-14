/**
 * Created by dos on 21.07.2016.
 */
public class Player {
    int number = 0;
    public void guess(){
        number = (int)(Math.random()*10);
        System.out.println("I think this number is "+ number);
    }
}
    class GameLauncher{
    public static void main(String[] args){
        GuessGame game = new GuessGame();
        game.startGame();
    }
}