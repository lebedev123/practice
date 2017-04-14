package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * HashMap
 */
public class HashTest {
    public static void main(String[] args) {
        Map<Integer,String>  hashmap = new HashMap<>();
        hashmap.put(34,"First");
        hashmap.put(24,"Second");
        hashmap.put(100,"Third");
        String compute = hashmap.compute(24, new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer, String s) {
                return new String(s + " " + integer);
            }
        });
        System.out.println(compute);
    }



}
