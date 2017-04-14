package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildCard {
    public static void printList(List<?> list) {
        for (Object elem: list)
            System.out.print(elem + " ");
        System.out.println();
    }
    static <T> List<T> makeList(T ... args){
        List<T> result = new ArrayList<T>(Arrays.<T>asList(args));
        return result;
    }

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3);
        List<String>  ls = Arrays.asList("one", "two", "three");
        printList(li);
        printList(ls);
    }


}