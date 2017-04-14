package collections.Lesson.Map;

import java.util.*;

/**
 * Created by dos on 20.10.2016.
 */
public class TestHashMap {
    public static void main(String[] args){
        /*HashMap<String, Employee> staff = new HashMap<>();
        staff.put("1",new Employee("John",2000,1990,7,1));
        staff.put("2",new Employee("Jack",2000,1994,5,6));
        staff.put("3",new Employee("Heffer",2000,1993,3,25));
        System.out.println(staff);
        staff.remove("1");
        staff.put("4",new Employee("Hanna",2100,1997,5,24));
        System.out.println(staff.get("4"));
        for(Map.Entry<String, Employee> staff1 : staff.entrySet()){
            String key = staff1.getKey();
            Employee employee = staff1.getValue();
            System.out.println(key.toString()+ " : " + employee.getName() + " : " + employee.getSalary() + " : " + employee.getHireDate());
        }*/
        Map<Integer,String> map = new HashMap<>(5);
        map.put(5,"a");
        map.put(4,"b");
        map.put(3,"c");
        map.put(2,"d");
        map.put(1,"e");
        map.put(0,"f");
        System.out.println(map);
        Map linkedmap = new LinkedHashMap(); // соблюдает порядок вставки
        linkedmap.put(5,"a");
        linkedmap.put(4,"b");
        linkedmap.put(3,"c");
        linkedmap.put(2,"d");
        linkedmap.put(1,"e");
        System.out.println(linkedmap);
        Map<Integer,Integer> parametrMap = new LinkedHashMap<>(10,1.1f,true); // accessOrder определяет доступ к элементам, элементы к которым доступ производился меньше всего раз(перезапись или считывание(get и put)) будут в начале
        parametrMap.put(34,134);
        parametrMap.put(21,121);
        parametrMap.put(11,111);
        parametrMap.put(5,105);
        parametrMap.put(35,135);
        parametrMap.put(50,150);
        parametrMap.put(51,151);
        parametrMap.put(65,165);
        parametrMap.put(75,175);
        parametrMap.put(99,199);
        parametrMap.put(88,188);
        parametrMap.put(87,187);
        parametrMap.put(82,182);
        parametrMap.put(86,186);
        parametrMap.get(88); // теперь последнее значение при выводе будет 88
        System.out.println(parametrMap);
    }
}
