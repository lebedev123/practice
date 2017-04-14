package collections.Lesson.Map;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by dos on 25.11.2016.
 */
public class ManagerTest {
    enum Season{Winter,Summer};
    static int hash(String a){
        int hash = 0;
        for(int i =0; i< a.length();i++){
            int l  = a.charAt(i);
            char l1 = a.charAt(i);
            hash = 31 * hash + a.charAt(i);
        }
        return hash;
    }
    public static void main(String[] args) {
        Manager boss = new Manager("Klark Kent", 80000, 1987, 12, 15);
        boss.setBonus(5000);
        Employee[] staff = new Employee[3];
        staff[0] = boss;
        staff[1] = new Employee("Thomas Jefferson", 50000, 1990, 3, 10);
        staff[2] = new Employee("Frederik Douglass", 49000, 1990, 4, 14);
        Manager m = new Manager("lol",900,900,4,7);
        System.out.println(m.getHireDate());
        Employee[] staff1 = new Employee[2];
        staff1[0] = new Manager("Thomas Jefferson", 50000, 1990, 3, 11);

        Employee boss1 = (Employee) staff[0];
        for(Object ob: staff) System.out.print(ob.getClass());
        for (Employee e : staff) {
            System.out.println(e.getName() + "  " + e.getSalary() + "   " + e.getHireDate());
        }
        if (staff[0] instanceof Manager) {
            Manager i = (Manager) staff[0];
            System.out.println("0");
        }
        if (staff[1] instanceof Manager) {
            System.out.println("1");
            Manager i1 = (Manager) staff[1];
        }
        Manager g3 = new Manager("Frederik Douglass", 49000, 1990, 4, 9);
        System.out.print(g3.getName());
        String g = "Okay";
        String g1 = new String("Okay");
        System.out.println(g.hashCode() + " " + g1.hashCode() +" " +hash(g) +" " + hash(g1));
        System.out.println(staff[0].equals(boss));
        System.out.println(staff[0].equals(staff1[0]));
        System.out.println(staff[0].toString());
        System.out.println(staff[0]);

        int[] staff3 = {1,2,3};

        String s = Arrays.toString(staff3);
        System.out.print(s);
        Season n = Season.Summer;
        System.out.print(n);
        Class cl1 = Date.class;


    }
}

class Employee {
  private String name;
  private double salary;
  private LocalDate hireDate;

  public Employee(String name, double salary, int year, int month, int day) {
      this.name = name;
      this.salary = salary;
      hireDate = LocalDate.of(year, month, day);
  }

  public String getName() {
      return name;
  }

  public double getSalary() {
      return salary;
  }

  public LocalDate getHireDate() {
      return hireDate;
  }

  public void raiseSalary(double percent) {
      double raise = salary * percent / 100;
      salary += raise;
  }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }
    public String getDescription(){
        return "description";
    }

    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
    public void update(){

    };

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

}
