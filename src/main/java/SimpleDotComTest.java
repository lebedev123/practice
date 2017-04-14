/**
 * Created by dos on 01.09.2016.
 */
public class SimpleDotComTest{
    int[] locationCells;
    int numOfHits=0;
    public  String checkYourself(String stringGuess){
        int guess = Integer.parseInt(stringGuess);
        String result = "Мимо";
        for(int cell : locationCells){
            if (guess == cell){
                result = "Попал";
                numOfHits++;
                break;
            }
        }
        if (numOfHits == locationCells.length){
            result = "Потопил";
        }
        System.out.println(result);
        return result;

    }}