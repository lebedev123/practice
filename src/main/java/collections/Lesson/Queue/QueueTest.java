package collections.Lesson.Queue;

import Threads.Priority;
import Threads.Q;

import java.util.*;

public class QueueTest {


    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(2);
        queue.add(4);
        queue.add(5);
        queue.add(1);
        queue.add(6);
        queue.add(31);
        queue.add(32);
        queue.add(33);
        queue.add(34);
        queue.add(35);
        PriorityQueue<Integer> q = new PriorityQueue<>(queue);
       while(!queue.isEmpty()){
            System.out.print(queue.poll() + "  ");
        }
        System.out.println("\nPriority");
        System.out.println(q); // sout вызывает tostring который использует итератор который в свою очередь не гарантирует порядок

        PriorityQueue<Integer> q1 = new PriorityQueue<>();
        q1.add(4);
        q1.add(2);
        q1.add(1);
        q1.add(3);
        q1.add(10);
        q1.add(14);
        q1.add(8);
        q1.add(9);
        q1.add(5);
        System.out.println(q1);
        /*while (!q1.isEmpty()){
            System.out.print(q1.poll() + "  ");
        }*/

        System.out.println("Iterator");
        for (Integer integer : q1) {
            System.out.print(integer + " ");
        }

    }
}
