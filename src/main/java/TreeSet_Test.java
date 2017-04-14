import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by dos on 19.10.2016.
 */
public class TreeSet_Test{
    ArrayList<Book> books = new ArrayList<>();
    public static void main(String[] args) {
        new TreeSet_Test().go();
    }
    public void go() {
        String b1 = new String("Sabaton/The last battle");
        String b2 = new String("Iron Maiden/Fear of the dark");
        String b3 = new String("Zet/Abba");
        addBook(b1);
        System.out.println(books);
        addBook(b2);
        addBook(b3);
        ComparatorBooks comparator = new ComparatorBooks();
        TreeSet<Book> book = new TreeSet<>(comparator);
        book.addAll(books);
        System.out.println(book);
    }

    void addBook(String lineToParse) {
        String[] tokens = lineToParse.split("/");
        Book nextSong = new Book(tokens[0], tokens[1]);
        books.add(nextSong);
    }
}
class ComparatorBooks implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        return o1.title.compareTo(o2.title);
    }
}

class Book {
    String title;
    String autor;

    public Book(String t,String a) {
        title = a;
        autor = t;
    }
    public String toString(){
        return title+ "/"+autor;
    }
}
