import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by dos on 17.10.2016.
 */
public class SortMountains {
    LinkedList<Mountain> mtn = new LinkedList<>();
        class NameCompare implements Comparator<Mountain>{

            @Override
            public int compare(Mountain o1, Mountain o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }
    class HeightCompare implements Comparator<Mountain>{

        @Override
        public int compare(Mountain o1, Mountain o2) {
            return o1.getHeight().compareTo(o2.getHeight());
        }
    }
}
class Mountain{
    String name;
    String height;
    public String getName(){
        return name;
    }
    public String getHeight(){
        return height;
    }
}