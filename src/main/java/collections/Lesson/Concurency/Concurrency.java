package collections.Lesson.Concurency;

import Threads.SynchronizedBlocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Все потоки видят последнюю версию переменной/объекта
 * Lock Только при записи и удалении
 * Synchronized оборачивает все методы в synchronized(итераторы так же не допускают изменения во время чтения и тд)
 * В Concurrent блокировки не везде,только в специфических местах (быстрое при чтении но копирует медленновато)
 * При изменении используется Lock,который создает копию переменной(массива), изменяет ее, и ссылка в volatile переносится на новый объект
 *
 */
public class Concurrency {
    public static void main(String[] args) {
        List<Integer>  synchronizedList= Collections.synchronizedList(new ArrayList<Integer>());
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        Collections.fill(synchronizedList,100);
        Collections.fill(copyOnWriteArrayList,100);
        System.out.println("List synchronized: ");
    }
}
