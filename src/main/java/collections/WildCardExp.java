package collections;

import java.util.List;

public class WildCardExp{
    public static <E> void funct1(final List<E > list1, final E something) {
        list1.add(something);
    }

    public static void funct2(final List<?> list, final Object something) {
        //list.add(something); // does not compile
    }
    public static <E> void funct1(final List<E> list) {
        list.add(list.get(0));
    }

    public static void funct2(final List<?> list) {
        //list.add(list.get(0)); // !!!!!!!!!!!!!! won't compile !!!!!!!!!
    }
}