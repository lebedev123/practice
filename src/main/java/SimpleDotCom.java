/**
 * Created by dos on 01.09.2016.
 */
import java.io.*;
import java.util.ArrayList;

public class SimpleDotCom {
   /* public static void main(String[] args) {
        int numofguesses=0;
        GameHelper helper = new GameHelper();
        SimpleDotComTestLul s1 = new SimpleDotComTestLul();
        int position = (int)(Math.random()*5);
        int[] locations ={position,position+1,position+2};
        s1.setLocationCells(locations);
        boolean isAlive =true;
        while(isAlive == true){
            String guess = helper.getUserInput("Введите число");
            String result = s1.checkYourself(guess);
            numofguesses++;
        //String result = s1.checkYourself(userGuess);
       // String testResult = "Неудача";
        if (result.equals("Потопил")) {
            //testResult = "Пройден";
            isAlive = false;
            System.out.println("U need " + numofguesses + " turns");
        }
    }}*/

    class SimpleDotComTestLul{
    private ArrayList<String> locationCells;
    int numOfHits=0;
    public void setLocationCells(ArrayList<String> locs){
        locationCells = locs;
    }
    public  String checkYourself(String userInput){
        String result = "Мимо";
        int index = locationCells.indexOf(userInput);
            if (index>=0) {
                locationCells.remove(index);
                if (locationCells.isEmpty()) {
                    result = "Потоплен";
                } else result = "Попал";
            }
        return result;

    }}

    class GameHelper{
        public String getUserInput(String prompt) {
            String inputLine = null;
            System.out.print(prompt + " ");
            try {
                BufferedReader is = new BufferedReader(new InputStreamReader((System.in)));
                inputLine = is.readLine();
                if (inputLine.length() == 0) return null;
            } catch(IOException e){
            System.out.println("IOException " + e);
        }
        return inputLine;
    }
    }}
