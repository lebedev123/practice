import java.util.*;

/**
 * Created by dos on 30.11.2016.
 */
public class CloneTest implements Cloneable {
    String name;
    int age;
    CloneTest(String name,int age){
        this.name = name;
        this.age = age;
    }
    public CloneTest clone() throws CloneNotSupportedException {
        return (CloneTest) super.clone();
    }
    public CloneTest superClone() throws CloneNotSupportedException {
        CloneTest test = (CloneTest) super.clone();
        test.name = name;
        test.age = age;
        return  test;
    }
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTest test1 = new CloneTest("Tom",32);
        CloneTest test2 =  test1.clone();//неполное клонирование
        CloneTest test3 = test1.superClone(); // полное копирование
        Employeee employeee = new Employeee("Jack",33,true);
        Employeee employeee1 = employeee.clone();
    }
}
class Employeee extends CloneTest implements Cloneable{
    boolean boss;
    Employeee(String name, int age, boolean boss){
        super(name,age);
        this.boss = boss;
        List a = new ArrayList();
        Integer a1 = 34;
    }
    public Employeee clone() throws CloneNotSupportedException {
        return (Employeee) super.clone();
    }
}