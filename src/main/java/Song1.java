/**
 * Created by dos on 16.10.2016.
 */
public class Song1 implements Comparable<Song1>{
    String title;
    String artist;
    String rating;
    String bpm;

    public boolean equals(Object o){
        Song1 s = (Song1) o;
        return getTitle().equals(s.getTitle());
    }
    public int hashCode(){
        return title.hashCode();
    }
    Song1(String artist,String title,String rating,String bpm){
        this.artist = artist;
        this.title = title;
        this.rating = rating;
        this.bpm = bpm;
    }
    public String getTitle(){
        return title;
    }
    public String getArtist(){
        return artist;
    }
    public String getRating(){
        return rating;
    }
    public String getBpm(){
        return  bpm;
    }
    public String toString(){
        return  artist + " - " + title ;
    }

    @Override
    public int compareTo(Song1 o) {
        return title.compareTo(o.getTitle());//передаем управление в compareTo для String и он сравнивает title
    }
}
