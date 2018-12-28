import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
      // B b = new B();
        Class.forName("B");
    }
}

class A {
    static int stat = 4;

    static {
        System.out.println("A static Init block");
    }

    int nonstat;

    public A() {
        System.out.println("A constructor");
    }
}

class B extends A {
    static int statB = 5;
    static {
        System.out.println("B static init block");
    }

    public B() {
        System.out.println("B constructor");
    }

}