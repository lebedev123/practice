import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by dos on 12.10.2016.
 */
public class DungeonTest {
    public static void main(String [] args){
        DungeonGame d = new DungeonGame();
        System.out.println(d.getX() + d.getY() + d.getZ());
        try {
            FileOutputStream fos = new FileOutputStream("dg.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(d);
            FileInputStream fis = new FileInputStream("dg.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            d = (DungeonGame)ois.readObject();
            System.out.println(d.getX() + d.getY() + d.getZ());
            ois.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
