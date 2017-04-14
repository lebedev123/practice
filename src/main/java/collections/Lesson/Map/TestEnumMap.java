package collections.Lesson.Map;


import collections.Lesson.Set.TestEnumSet;

import java.util.*;

/**
 * Created by dos on 14.01.2017.
 */
public class TestEnumMap {
    public static void main(String[] args) {
        EnumMap<TestEnumSet.Color, Employee> enumMap = new EnumMap<TestEnumSet.Color, Employee>(TestEnumSet.Color.class);
        enumMap.put(TestEnumSet.Color.RED,new Employee("JJ",200,1465,11,12));
        for (Map.Entry k: enumMap.entrySet() ) {
            System.out.println(k.getKey() + " : " + k.getValue());
        }
        enumMap.forEach((k,v)-> System.out.println(k + v.getName() +" " +  v.getSalary() + v.getHireDate()));
        Integer[] l = new Integer[5];
        l[0]=5;
        l[1]=1;
        l[2]=2;
        List<Integer> list = Arrays.asList(l);
        //Arrays.asList(l).remove(5);

    }
}
