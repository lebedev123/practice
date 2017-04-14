package collections.Lesson.Map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LRUCashOnMap<K,V> extends LinkedHashMap<K,V> {
    private final int capacity;

    public LRUCashOnMap(int capacity) {
        super(capacity+1,1.1f,true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size()>capacity;
    }

    public static void main(String[] args) {
        LRUCashOnMap<Integer,String> cash = new LRUCashOnMap<>(3);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ключ:значение");
        while (scanner.hasNext()){
            String localString = scanner.nextLine();
            if(localString.contains("exit")) break;
            int localId = Integer.parseInt(localString.split(":")[0]);
            String localName = localString.split(":")[1];
            cash.put(localId,localName);
        }
        System.out.println("Map имеет значения : " + cash);
    }


}
