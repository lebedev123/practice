import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * Created by dos on 19.10.2016.
 */
public class TreeSet_JukeBox {
    ArrayList<Song1> songList = new ArrayList<>();

    public static void main(String[] args) {
        TreeSet_JukeBox box = new TreeSet_JukeBox();
        box.go();
    }

    public void go() {
        getSongs();
        System.out.println(songList);
        NameCompare compare = new NameCompare();
        TreeSet<Song1> songSet = new TreeSet<>(compare);
        songSet.addAll(songList);
        System.out.println(songSet);
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
class ArtistCompare implements Comparator<Song1> {

    @Override
    public int compare(Song1 o, Song1 o1) {
        return o.getArtist().compareTo(o1.getArtist());
    }
}

class NameCompare implements Comparator<Song1> {

    @Override
    public int compare(Song1 o1, Song1 o2) {
        return o1.title.compareTo(o2.title);
    }
}

