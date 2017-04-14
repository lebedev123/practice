package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        People people = new People();
        Class c = people.getClass();
        Method[] methods = c.getMethods();
        System.out.println("Methods");
        for(Method m : methods){
            System.out.println(m.getName());
        }
        Class[] interfaces = c.getInterfaces();
        System.out.println("implementation");
        for (Class clas : interfaces) {
            System.out.println(clas.getName());
        }
        Field[] fields = c.getFields();
        System.out.println("Fields");
        for(Field f : fields){
            System.out.println(f.getModifiers() + " " + f.getName() + " " + f.getType());
        }

    }
}
