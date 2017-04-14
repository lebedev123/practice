package Reflection;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class People implements Serializable {

    public String name;

    public int age;

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        People people = new People(); // Создание объекта people
        Class myClass = people.getClass(); // Получение объекта Class
        Class class1 = People.class; // тоже  самое
        String name = class1.getClass().getName(); //Имя
        System.out.println(name + " " + people.getClass().getName()); // вывод
        Class c1 = Class.forName("Reflection.People"); // Объект класс для строки
        Package p = c1.getPackage(); //пакет


        Class c = people.getClass();
        Method[] methods = myClass.getMethods();
        System.out.println("Methods");
        for(Method m : methods){
            System.out.println(m.getName());
        }
        Field[] fields = c.getFields();
        System.out.println("Fields");
        for(Field f : fields){
            System.out.println(f.getModifiers() + " " + f.getName() + " " + f.getType());
        }


    }


}



