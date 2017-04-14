package JavaExact;

public class Exact {

    public static void main(String[] args) {
        int x = 10000;
        int y = 10000;
        Object z;

        z = Math.addExact(x, y);
        System.out.println("addExact: " + x + " + " + y + " = " + z);
        z = Math.subtractExact(x, y);
        System.out.println("subtractExact: " + x + " - " + y + " = " + z);
        z = Math.multiplyExact(x, y);
        System.out.println("multiplyExact: " + x + " * " + y + " = " + z);
        z = Math.incrementExact(x);
        System.out.println("incrementExact: " + x + " + 1 = " + z);
        z = Math.decrementExact(y);
        System.out.println("decrementExact: " + y + " - 1 = " + z);
        z = Math.negateExact(x);
        System.out.println("negateExact: " + x + " * -1 = " + z);
    }
}

