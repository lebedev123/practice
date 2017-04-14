package PrintAndWrite;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by dos on 07.10.2016.
 */
public class WriteAFile {
    public static void main(String[] args){
        try{
            FileWriter writer = new FileWriter("Foo.txt");
            writer.write("Hello");
            writer.close();
            FileReader file1 = new FileReader("Foo.txt");
            int  i = 0;
            while((i = file1.read())!=-1){
                System.out.print((char)i);
            }

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }


}
