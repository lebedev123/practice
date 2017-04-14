package collections.Lesson.Set;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by dos on 16.12.2016.
 */
public class TestHashSet {
    public static void main(String... args){
        Map<Integer,String> staff = new HashMap<>();
        staff.put(34,"Stan");
        staff.put(1,"Gregory");
        staff.put(2,"Lion");
        staff.put(3,"George");
        staff.put(4,"Kevin");
        staff.put(5,"Sebastian");
        Set<Integer> IDset = staff.keySet();
        IDset.removeIf(k-> k==3 && k ==4);
        IDset.forEach(k -> System.out.println(k));
        staff.forEach((k,name)-> System.out.println(k + " " + name));
        LocalDate test = LocalDate.of(1995,7,21);
        LocalDate test1 = test.plusDays(1000);
        System.out.println(test.toString());
        System.out.println(test1.toString());
        test.plusDays(1000);
        System.out.println(test.toString());
        LocalDate test2 = test;
        System.out.println(test.toString());
        System.out.println(test1.toString());
        System.out.println(test2.toString());
        LocalDate date = LocalDate.now();

    }
}
