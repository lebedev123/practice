package Serilzation;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestReferences {
    public static void main(String[] args) throws InterruptedException {
        TestObjectA a = new TestObjectA(1);
        TestObjectB b = new TestObjectB(34, a);
        TestObjectC c = new TestObjectC(48, b);
        File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "object2.dat");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            objectOutputStream.writeObject(a);
            objectOutputStream.writeObject(b);
            a = (TestObjectA) objectInputStream.readObject();
            b = (TestObjectB) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }


        Thread.currentThread().sleep(5000);
        System.out.println(c);

    }

}

class TestObjectA implements Serializable {
    int id;

    public TestObjectA(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return " idA : " + id;
    }
}

class TestObjectB implements Serializable {
    int id;
    TestObjectA a;

    public TestObjectB(int id, TestObjectA a) {
        this.id = id;
        this.a = a;
    }

    @Override
    public String toString() {
        return "idB : " + id + " A : " + a.toString();
    }

}

class TestObjectC implements Serializable {
    int id;
    TestObjectB b;

    public TestObjectC(int id, TestObjectB b) {
        this.id = id;
        this.b = b;
    }

    @Override
    public String toString() {
        return "idC : " + id + " B : " + b.toString();
    }
}