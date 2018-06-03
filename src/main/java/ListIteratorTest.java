import sun.reflect.generics.tree.Tree;

import java.util.*;

public class ListIteratorTest {
    public static void main(String[] args) {
        int count = 100_000;
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        arrayList.add(new Integer(-1));
        linkedList.add(new Integer(-1));
        ListIterator<Integer> listIterator;
        listIterator = arrayList.listIterator();
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            listIterator.add(new Integer(count));
        }
        System.out.println("ArrayList iterator add : " + (System.currentTimeMillis() - start + " ms"));


        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            listIterator.previous();
            listIterator.remove();
        }
        System.out.println("ArrayList iterator remove : " + (System.currentTimeMillis() - start + " ms"));

        start = System.currentTimeMillis();
        listIterator = linkedList.listIterator();
        for (int i = 0; i < count; i++) {
            listIterator.add(new Integer(count));
        }
        System.out.println("LinkedList iterator add : " + (System.currentTimeMillis() - start + " ms"));

        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            listIterator.previous();
            listIterator.remove();

        }
        System.out.println("LinkedList iterator remove : " + (System.currentTimeMillis() - start + " ms"));
    }

}
