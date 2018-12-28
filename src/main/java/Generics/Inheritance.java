package Generics;

import java.util.*;

public class Inheritance {

    public static void main(String[] args) {
        List<Integer> list = Collections.synchronizedList(new LinkedList<>());
        while (true) {
            System.out.println("Заполняю");
            for (int i = 0; i < 100; i++) {
                System.out.println("Added " + i);
                list.add(i);
            }
            System.out.println("Запускаю потоки");
            for (int i = 0; i < 100; i++) {
                new Thread(new Task(list, i)).start();
            }
        }
    }

}


class Task implements Runnable {

    private List<Integer> operations;
    private Integer id;

    public Task(List<Integer> operations, Integer id) {
        this.operations = operations;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("Ожидаю на слипе");
            Thread.sleep(2000);
            System.out.println("Removed " + id);
            operations.remove(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
