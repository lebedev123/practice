package collections.Lesson.Map;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * При добавлении записи в HashMap и последующем присваивании ключу значения null ссылка в коллекции на запись остается и запись не удаляется
 * При использовании WeakHashMap запись удаляется если единственная ссылка на нее - в WeakHashMap
 */
public class WeakHashMapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new WeakHashMap<>();
        Integer a = new Integer(34);
        map.put(a, "random integer");
        a = null;
        System.gc();
        for(int i=0;i<100;i++){
            if(map.isEmpty()){
                System.out.println("Empty");
                break;
            }else{
                System.out.println("Is not empty");
            }
        }
    }

}
