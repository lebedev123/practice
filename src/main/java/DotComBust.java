import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by dos on 04.09.2016.
 */
public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<>();
    private int numOfGuesses=0;

    private void setUpGame(){
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        System.out.println("Ваша цель - потопить три сайта");
        System.out.println("Pets.com, eToys.com , Go2.com");
        System.out.println("Попытайтесь потопить их за минимальное количество ходов");

        for (DotCom dotComToSet : dotComList){
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }
    class  DotCom{
        private ArrayList<String> locationCells;
        private String name;
        public void setLocationCells(ArrayList<String> locs){
            locationCells = locs;
        }
        public void setName(String n){
            name = n;
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
    private void startPlaying(){
        while(!dotComList.isEmpty()){
            String useGuess = helper.getUserInput("Сделайте ход");
            checkUserGuess(useGuess);
        }
        finishGame();
    }
    private void checkUserGuess(String userGuess){
        numOfGuesses++;
        String result = "Мимо";
        for(DotCom dotComToTest : dotComList){
            result= dotComToTest.checkYourself(userGuess);
            if(result.equals("Попал")){
                break;
            }
            if(result.equals("Потопил")) {
                dotComList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }
    private void finishGame(){
        System.out.println("Все корабли уничтожены");
        if(numOfGuesses<=18){
            System.out.println("God damn , its " +numOfGuesses +" attempts");
        }else System.out.println("Oh shit, u r cucked, its "+ numOfGuesses+" attempts");
    }
    class GameHelper{
        private static final String alphabet ="abcdefg";
        private int gridLenght = 7;
        private int gridSize = 49;
        private int [] grid = new int[gridSize];
        private int comCount=0;
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
            return inputLine.toLowerCase();
        }
        public ArrayList<String> placeDotCom(int comSize){
            ArrayList<String> alphaCells = new ArrayList<String>();
            String[] alphacoords = new String [comSize];
            String temp = null;
            int [] coords = new int[comSize];
            int attempts =0;
            boolean success = false;
            int location=0;

            comCount++;
            int incr = 1;
            if((comCount%2)==1){
                incr=gridLenght;
            }
            while(!success && attempts++ <200){
                location=(int) (Math.random()*gridSize);
                int x=0;
                success=true;
                while(success && x<comSize){
                    if(grid[location]==0) {
                        coords[x++] = location;
                        location += incr;
                        if (location >= gridSize) {
                            success = false;
                        }
                        if (x > 0 && (location % gridLenght) == 0) {
                            success = false;
                        }
                    }else{success=false;}
                    }
                }
        int x=0;
        int row=0;
        int column=0;
        while(x<comSize){
            grid[coords[x]]=1;
            row=(int)(coords[x]/gridLenght);
            column=coords[x]%gridLenght;
            temp=String.valueOf(Integer.toString(row));
            x++;
        }
            return  alphaCells;
        }
    }
    public static void main(String[] args){
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
