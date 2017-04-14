import java.time.LocalDate;
import java.util.*;

/**
 * Created by dos on 07.12.2016.
 */
public class Obobsh<T> {
    T first;
    T second;
    public static void  main(String[] args){
        Obobsh<String> a = new Obobsh<>();
        Obobsh<Integer> b = new Obobsh<>();
        if(a.getClass() == b.getClass()) System.out.println("ravni");//типы стерты
        DateInterval dateInterval = new DateInterval();
        LocalDate date = LocalDate.now();
        //dateInterval.setSecond(date); // При стирании тип становится Pair,в Pair есть метод setSecond(T newvalue)
        System.out.println(dateInterval);//где T может быть Object при стирании типов
        DateInterval newvalue = new DateInterval();
        newvalue.Hello(LocalDate.now());
        List<String> a23 = new LinkedList<>();
        a23.add("Hi");
        a23.add("Im");
        a23.add("Bob");
        System.out.println(a23.get(2));
        List<Pair<String>> pairList = new LinkedList<>();
        pairList.add(new Pair<>("Tetya","Sraka"));
        pairList.add(new Pair<>("Dyadya","Bafomet"));
        Iterator iterator = pairList.iterator();
        Pair<String> str1 = (Pair<String>) iterator.next();
        Pair<String> str2 = (Pair<String>) iterator.next();
        iterator.remove();
        System.out.println(str2.toString());
        System.out.println(str1.toString());
        DateInterval[] dateIntervals = new DateInterval[3];
        dateIntervals[0] = new DateInterval();
        dateIntervals[1] = new DateInterval();
        dateIntervals[2] = new DateInterval();
    }
}
class DateInterval extends Pair<LocalDate>{

    public void setSecond (LocalDate second){
        if(second.compareTo(getFirst()) >=0)
            super.setSecond(second);
    }
    public void supKek(Pair<? super DateInterval> result){

    }
    public void Hello(LocalDate newvalue){
        System.out.println("Im hello from DateInterval" + newvalue.toString());
    }
}
class A1{

}
class A2 extends A1{

}
class A3 extends A2{
    void Hi(Pair<? super A3 > l1){
    }
    public static void minmax (Manager[] a, Pair<? super Manager> result){
    }

    public static void main(String[] args) {
        A3 a3 = new A3();
        Pair<String> pair = new Pair<>();
        Pair<A3> pair1 = new Pair<>();
        Manager[] a = new Manager[10];
        Pair<A2> a2 = new Pair<>();
        a3.Hi(a2);
        Pair<Employee> employee = new Pair<>();
        A3.minmax(a,employee);
    }


}


