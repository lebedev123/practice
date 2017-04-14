/**
 * Created by dos on 09.11.2016.
 */
public class TestBreak {
    public static void main(String[] args){
        int j =1;
        int j1 =1;
        int y = 1;
        for(int i =0;i<10;i++){
            j++;
            y=j1++;
            System.out.println(j + " " + y + " " + j1);
        }
        while(true){
            j++;
            if (j == 15) break;
            else continue;
        }
    }
}
