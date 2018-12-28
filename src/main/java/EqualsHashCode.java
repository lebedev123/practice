import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class EqualsHashCode {
    public static void main(String[] args) {
        Employee employee = new Employee("rajeev", 24);
        Employee employee2 = new Employee("rajeev", 24);
        HashMap<Employee,String> employees = new HashMap<>();
        employees.put(employee,"1");
        employee.setAge(25);
        System.out.println(employees.get(employee));
    }
}

class Employee {

    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this)
            return true;
        if (!(obj instanceof Employee))
            return false;
        Employee employee = (Employee) obj;
        return employee.getAge() == this.getAge()
                && employee.getName() == this.getName();
    }

    // commented
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

}