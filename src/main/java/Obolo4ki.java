import java.util.Arrays;
import java.util.List;

/**
 * Created by dos on 14.01.2017.
 */
public class Obolo4ki {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("1",1,1,1,1);
        employees[1] = new Employee("1",1,1,1,1);
        employees[2] = new Employee("1",1,1,1,1);

        List<Employee> list = Arrays.asList(employees);
        list.forEach(e-> System.out.println(e.getName() + e.getHireDate() + e.getSalary()));
    }
}
