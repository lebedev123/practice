import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

/**
 * Created by dos on 19.10.2016.
 */
public class HashSet_JukeBox {

    ArrayList<Song1> songList = new ArrayList<>();

    public static void main(String[] args) {
        HashSet_JukeBox box = new HashSet_JukeBox();
        box.go();
    }


    //equals && hashCode переопределены в Song1

    public void go() {
        getSongs();
        System.out.println(songList);


    }

    void getSongs() {
        try {
            File file = new File("Songs.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                addSong(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");
        Song1 nextSong = new Song1(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(nextSong);
    }
}

