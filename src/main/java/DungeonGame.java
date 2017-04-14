import java.io.Serializable;

/**
 * Created by dos on 12.10.2016.
 */
public class DungeonGame implements Serializable {
    public int x= 3;
    transient long y =4;
    private short z = 5;
    short getZ (){
        return z;
    }
    long getY(){
        return y;
    }
    int getX(){
        return x;
    }
}
