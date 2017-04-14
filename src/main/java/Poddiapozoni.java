import java.util.*;

/**
 * Created by dos on 14.01.2017.
 */
public class Poddiapozoni {
    public static void main(String[] args) {
        SortedMap<Integer, String> map = new TreeMap<>();
        map.put(1,"1");
        map.put(2,"2");
        map.put(3,"3");
        Map<Integer, String> newlist = map.subMap(1, 2);
        newlist.forEach((k,v)-> System.out.println(k.toString() +" " + v.toString()));
        ArrayList<String> strings = new ArrayList<>();
        ArrayList rawlist = strings;
        rawlist.add(new Date());
        //strings.forEach(s-> System.out.println(s));
        List<String> safestring = Collections.checkedList(strings,String.class);
        List newrawlist = safestring;
        newrawlist.add(new Date());

    }
}
