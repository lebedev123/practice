package collections.Lesson.List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;

/**
 * ArrayList - быстрый доступ , вставка и удаление в начало и конец если не достигнута макс длина(Default capacity 10)
 * LinkedList - медленный доступ ,быстрая вставка и удаление,состоит из Node - last,first и size
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        list.add("John");
        list.add("Ford");
        linkedList.add(34);
        linkedList.add(38);
        Spliterator<Integer> spliterator = linkedList.spliterator();
        spliterator.characteristics();




    }

    }
