import java.util.ArrayList;
import java.util.List;

public class GenericTests {
    public static void main(String[] args) {
        //подстановки с ограничениями супертипа позволяют записывать данные в обобщенный объект
        //то есть мы уверены что  внутри по ссылке лежит реализация которая содержит объекты ниже по иерархии - мы точно уверены что реализация Pair поддерживает добавление элементов Employee и потомков
        //Например реализация с типом Numeric позволяет добавлять в коллекцию все типы которые наследуются от Numeric , то есть будет реализация Pair<Numeric>
        // (но не Object, так как в реализацию Pair<Numeric> нельзя добавить Object)
        Pair<? super Employee> superEmployes = new Pair<>();
        superEmployes.setFirstElement(new Employee("John", 34)); // Работает потому что мы точно уверены что в реализации лежит тип выше Employee и мы можем добавлять все наследники
        superEmployes.setFirstElement(new Manager("John", 34, ""));
        Object o = superEmployes.getFirstElement();

        //подстановки с ограничениями подтипа позволяют читать данные из обобщенного объекта
       // Мы точно уверены что любой объект который мы вытащим из Pair полюбому является или наследуется от Employee поэтому get возвращает объект Employee
        // Но добавить объект мы не можем так как компилятор не знает какой тип у реализации extendEmployers
        // ( Если тип Pair<Manager> то мы можем добавлять только объекты Manager и ниже но не объекты Employee а если  Если тип Pair<Employee> то объеты Employee и ниже)
        Pair<? extends Employee> extendEmployers = new Pair<Manager>();
//        extendEmployers.setFirstElement(new Employee("John", 34)); // Не работает потому что типы могут не совпасть - например в реализации лежит тип Manager а мы пытаемся добавить Employee
//        extendEmployers.setFirstElement(new Manager("John", 34, ""));
        Employee e = extendEmployers.getFirstElement();

        List<Number> intList = new ArrayList<Number>();
        intList.add(new Integer(10));
        intList.add(new Float(10.0f));

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(100);
        printList(list);
        List<String> strList = new ArrayList<>();
        strList.add("10");
        strList.add("100");
        printList(strList);

    }

    static <T> void printList(List<T> list) {
        for (T l : list)
            System.out.println("{" + l + "}");
    }
}


class Manager extends Employee {
    private String department;

    public Manager(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}


class Pair<T> {
    private T firstElement;
    private T secondElement;

    public T getFirstElement() {
        return firstElement;
    }

    public void setFirstElement(T firstElement) {
        this.firstElement = firstElement;
    }

    public T getSecondElement() {
        return secondElement;
    }

    public void setSecondElement(T secondElement) {
        this.secondElement = secondElement;
    }
}
