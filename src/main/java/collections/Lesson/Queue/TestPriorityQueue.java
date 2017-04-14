package collections.Lesson.Queue;

import java.util.*;

/**
 * Created by dos on 15.12.2016.
 */
public class TestPriorityQueue {
    public static void main(String ... args){
        PriorityQueue<GregorianCalendar> pq = new PriorityQueue<>();
        pq.add(new GregorianCalendar(1906, Calendar.DECEMBER,9));
        pq.add(new GregorianCalendar(1815, Calendar.DECEMBER,10));
        pq.add(new GregorianCalendar(1903, Calendar.DECEMBER,3));
        pq.add(new GregorianCalendar(1910, Calendar.JUNE,22));
        for(GregorianCalendar p : pq){
            System.out.println(p.get(Calendar.YEAR));
        }
        System.out.println("Removing elemets ... ");
        while(!pq.isEmpty()){
            System.out.println(pq.remove().get(Calendar.YEAR));
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(1);
        queue.add(8);
        queue.add(7);
        queue.add(10);
        queue.add(13);
        queue.add(2);
        Integer gregorianCalendar = queue.peek(); // вытягивает певый элемент(голову) но не удаляет
        Integer gregorianCalendar1 = queue.poll();// вытягивает певый элемент(голову) и удаляет
        queue.offer(new Integer(34)); //Вставка (add вызывает offer)
        /* add remove element - бросают exception, offer pool peek - возвращают null*/

    }
}
