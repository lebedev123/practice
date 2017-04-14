package collections.Lesson.Map;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class HashMapToSet {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"Anele");
        map.put(4,"PogChamp");
        map.put(2,"DansGame");
        map.put(3,"Explain");
        List<Integer> l2 = new ArrayList(map.keySet());
        l2.sort((o1, o2) -> o1.compareTo(o2));
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::print);
        map.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer integer, String s) {
                System.out.println(integer+ " " + s);
            }
        });
        System.out.println("Fuck");
        Set<Map.Entry> set = new HashSet<>(map.entrySet());
        set.forEach(new Consumer<Map.Entry>() {
            @Override
            public void accept(Map.Entry entry) {
                System.out.println(entry);
            }
        });
    }
}
