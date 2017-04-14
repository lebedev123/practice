package collections.Lesson.Set;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by dos on 11.12.2016.
 */
public class TestSet {
    public static void main(String... args) throws FileNotFoundException {
        Set<String> words = new HashSet<>();
        long totaltime = 0;
        File file = new File("src/main/resources/1.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        try (Scanner in = new Scanner(fileInputStream)) {
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totaltime += callTime;
            }
        }
        Iterator<String> iter = words.iterator();
        for (int i = 1; i <= 20 && iter.hasNext(); i++)
            System.out.println(iter.next());
        System.out.println(" ... ");
        System.out.println(words.size() + " distinct words." + totaltime + " millisecond.");
    }
}
