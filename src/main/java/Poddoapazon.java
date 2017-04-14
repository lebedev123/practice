import java.util.*;

/**
 * Created by dos on 16.12.2016.
 */
public class Poddoapazon {
    public static void main(String... args) {
        List<EmployeeStaff> staff = new ArrayList<>();
        staff.add(new EmployeeStaff("Leon",1));
        staff.add(new EmployeeStaff("Anna",2));
        staff.add(new EmployeeStaff("Viktor",3));
        staff.add(new EmployeeStaff("Geroge",4));
        staff.add(new EmployeeStaff("John",5));
        staff.forEach((name) -> System.out.println(name.getName() + " " + name.getID()));
        List<EmployeeStaff> poddiapazon = staff.subList(2,4);
        poddiapazon.forEach((name) -> System.out.println(name.getName() + " " + name.getID()));
        poddiapazon.clear();
        staff.forEach((name) -> System.out.println(name.getName() + " " + name.getID()));
        ArrayList<String> list = new ArrayList<>();
        List<String> safeStrings = Collections.checkedList(list,String.class);
        List rawlist = safeStrings;
        rawlist.add(new Date()); // !!
        list.forEach(k-> System.out.println(k.toString()));
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.get(0);
        EmployeeStaff teststaf = new EmployeeStaff("Vitaliy",33);


    }
}
class EmployeeStaff{
    private String name;
    private int ID;
    EmployeeStaff(String name, int ID){
        this.name = name;
        this.ID = ID;
    }
    public String getName(){
        return name;
    }
    public int getID(){
        return ID;
    }
    public String l1(String a,String b){
        a = a+ b;
        return  a;
    }
    public void l12(String a,String b){
        System.out.println(a+ b);

    }
}