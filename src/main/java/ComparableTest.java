import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by dos on 29.11.2016.
 */
public class ComparableTest implements Comparable<ComparableTest> {
    private String name;

    ComparableTest(String value) {
        this.name = value;
    }

    String getName() {
        return name;
    }
    public static void main(String[] args){
        PersonComparator personComparator = new PersonComparator();
        TreeSet<NewPersonComp> treeSet = new TreeSet<>(personComparator);
        treeSet.add(new NewPersonComp("tom","kekov"));
        treeSet.add(new NewPersonComp("nikolay","petrov"));
        treeSet.add(new NewPersonComp("dmitry","yavin"));
        for(NewPersonComp p : treeSet){
            System.out.println(p.getName());
        }
    }

    @Override
    public int compareTo(ComparableTest o) {
        return name.length() - o.getName().length();
    }
}

class PersonComparator implements Comparator<NewPersonComp > {

    @Override
    public int compare(NewPersonComp  o1, NewPersonComp  o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
class NewPersonComp {
    String FirstName,SecondName;
    NewPersonComp(String firstName,String secondName){
        this.FirstName = firstName;
        this.SecondName = secondName;
    }
    String getName(){
        return FirstName + " " + SecondName;
    }
    public static void main(String[] args){
        PersonComparator personComparator = new PersonComparator();
        TreeSet<NewPersonComp> treeSet = new TreeSet<>(personComparator);
        treeSet.add(new NewPersonComp("tom","kekov"));
        treeSet.add(new NewPersonComp("nikolay","petrov"));
        treeSet.add(new NewPersonComp("dmitry","yavin"));
        for(NewPersonComp p : treeSet){
            System.out.println(p.getName());
        }
    }
}
