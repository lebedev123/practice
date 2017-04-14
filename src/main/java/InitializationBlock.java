import java.util.Random;

/**
 * Created by dos on 29.12.2016.
 */
public class InitializationBlock {
    String name;
    int age;
    int personId;
    static int id;

    //статический блок инициализации(бля статических переменных
    static {
        Random generator = new Random();
        id = generator.nextInt(10);
    }

    //Блок инициализации
    {
        personId = id;
        id++;
    }

    InitializationBlock(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return personId;
    }

    public String toString() {
        return "Name " + this.getName() + " Age " + this.getAge() + " Id " + this.getId();
    }

    public static void main(String... args) {
        InitializationBlock person1 = new InitializationBlock("Jack", 34);
        InitializationBlock person2 = new InitializationBlock("Homer", 22);
        InitializationBlock person3 = new InitializationBlock("John", 28);
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
        Random generator = new Random(100);
        Random generator1 = new Random(100);
        Random generator2 = new Random(100);
        int r1 = generator.nextInt();
        int r2 = generator1.nextInt();
        int r3 = generator2.nextInt();

    }
}
