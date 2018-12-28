package Serilzation;

import java.io.*;

public class SerInheritance {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream stream = new FileOutputStream("test.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream);
        B b = new B("Johny");
        objectOutputStream.writeObject(b);
        objectOutputStream.flush();
        objectOutputStream.close();
        FileInputStream stream1 = new FileInputStream("test.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(stream1);
        b = (B) objectInputStream.readObject();
        objectInputStream.close();
    }

}

class A {
    private int id;
    static int ID = 0;

    public A() {
        System.out.println("Parent constructor");
        this.id = ID++;
    }
}

class B extends A implements Serializable {

    private String name;

    public B(String name) {
        System.out.println("Child constructor");
        this.name = name;
    }
}

class C implements Externalizable{

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}