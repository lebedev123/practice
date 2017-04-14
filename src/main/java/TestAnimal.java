import java.util.ArrayList;
import java.util.List;

/**
 * Created by dos on 20.10.2016.
 */
public class TestAnimal {
    public static void main(String[] args){
        //ArrayList<Dog> dogs = new ArrayList<Animal>();
       // ArrayList<Animal> dog = new ArrayList<Dog>();
        List<Animal> list = new ArrayList<Animal>();
        ArrayList<Dog1> dogs = new ArrayList<Dog1>();
        List<Dog1> dog1List= dogs;
        ArrayList<Object> objects = new ArrayList<Object>();
        Animal animal = new Animal("GEpard");
        Dog1 dog = new Dog1("Gepard","Billy","Yellow",30);
        System.out.print(dog.colour);
        animal = dog;
        System.out.println(animal.type);
    }
}
class Dog1 extends Animal{
    String name;
    String colour;
    int age;

    Dog1(String type,String name,String colour,int age) {
        super(type);
        this.name = name;
        this.colour = colour;
        this.age = age;
    }
}
class Animal{
    String type;
    Animal(String type){
        this.type = type;
    }
}
