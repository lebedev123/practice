import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by dos on 23.11.2016.
 */
public class StringBuilderTest {
    public static void main(String[] args)  {
        StringBuilder builder = new StringBuilder();
        StringBuilder builder1 = new StringBuilder();
        builder.append("kek");
        builder.append("lol");
        builder.append(3);
        System.out.print(builder + " " + builder1);
        int[] array = new int[12];
        for (int i : array) {
            array[i] = ((int)(Math.random() * 31) - 15);
            System.out.println(array[i]);
        }
        final  int MAX = 10;
        int[][] odds = new int[MAX][];
        for(int n = 0; n<=MAX;n++){
            odds[n] = new int[n+1];
        }
    }
}
