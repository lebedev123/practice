/**
 * Created by dos on 30.07.2016.
 */
public class books {
    String name;
    public static  void main(String[] args){
        books[] book = new books[3];
        int z=0;
        while(z<4){
            z++;
            book[z]= new books();
            book[z].name="name";
            System.out.println(book[z].name + "- imya");


    }
}}
