/**
 * Created by dos on 21.07.2016.
 */

public class MovieTest{
    public static void main(String[] args){
        Movie one  = new Movie();
        one.title= "Kak progoret na akziyah";
        one.genre="Tragediya";
        one.rating = -2;
        Movie two = new Movie();
        two.title="Hidden pool";
        two.genre = "Comedy";
        two.rating = 5;
        two.playIt();
    }
}

