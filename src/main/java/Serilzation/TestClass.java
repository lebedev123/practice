package Serilzation;

import java.io.*;
import java.time.LocalDate;
import java.util.Date;

public class TestClass implements Serializable {

    private int data[];
    private NonSObject o;
    public transient String s;

    // Конструктор
    public TestClass() {
        o = new NonSObject(3);
        int length = r();
        data = new int[length];
        for (int i = 0; i < data.length; i++)
            data[i] = r();
        s = "Transient String";
    }

    // Генерация рандомного значения
    private static int r() {
        return (int) (Math.random() * 10);
    }


    public void printout() {
        System.out.println("This RandomClass has " + data.length + " random integers : ");
        System.out.println(this.o);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TestClass tc1 = new TestClass();
        TestClass tc2 = new TestClass();
        File path = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\object.dat");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
             ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            //Write
            LocalDate now = LocalDate.now();
            out.writeObject(now);
            out.writeObject(tc1);
            out.writeObject(tc2);
            System.out.println("Got it");
            System.out.println("Write time is : " + now);
            tc1.printout();
            tc2.printout();
            //Read
            now = (LocalDate) in.readObject();
            tc1 = (TestClass) in.readObject();
            tc2 = (TestClass) in.readObject();
            System.out.println("Got reading");
            System.out.println("Readed date is " + now);
            tc1.printout();
            tc2.printout();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
class NonSObject implements Serializable{
    int p;

    public NonSObject(int p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "NonSObject{" +
                "p=" + p +
                '}';
    }
}