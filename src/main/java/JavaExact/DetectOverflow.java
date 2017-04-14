package JavaExact;

public class DetectOverflow {

    public static void main(String[] args){
        int x = 1_000_000;
        int y = 1_000_000;
        long a = Long.MAX_VALUE;
        long b = Long.MAX_VALUE;
        Object z,c;
        System.out.println("Before Java 8");
        z = x*y;
        c=a*b;
        System.out.println("z = " + z);
        System.out.println("c = " + c);
        System.out.println("Since Java 8");
        try{
            z = Math.multiplyExact(x,y);
            c = Math.multiplyExact(a,b);
        }catch (ArithmeticException e){
            try{
                z = Math.multiplyExact((long)x,(long)y);
                c = null;
            }catch (ArithmeticException ex){
                z = null;
            }
        }
        if (z instanceof Integer) {
            System.out.println("z is instance of Integer: " + z);
        }
        if (z instanceof Long) {
            System.out.println("z is instance of Long: " + z);
        } else {
            System.out.println("Overflow for z");
        }

        if (c instanceof Integer) {
            System.out.println("Instance of Integer: " + c);
        }
        if (c instanceof Long) {
            System.out.println("Instance of Long: " + c);
        } else {
            System.out.println("Overflow for c");
        }
    }

}
