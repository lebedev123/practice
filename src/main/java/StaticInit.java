public class StaticInit {
    static {
        System.out.println("static block called main ");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10000);
//        StaticInitObject staticInitObject = new StaticInitObject();
//        StaticInitObject.str();
        E e = E.Artur;

    }


}

class StaticInitObject {
    static {
        System.out.println("static block called in test object");
    }

    public static void str() {
        System.out.println("str");
    }

}

enum E {
    Artur("Artur"),
    James("James");

    String name;

    E(String name) {
        this.name = name;
        System.out.println("Consctuctor created whit name : " + name);
    }
}