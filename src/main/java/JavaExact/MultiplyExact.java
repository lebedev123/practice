package JavaExact;

public class MultiplyExact {
    public static void main(String[] args) {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        Object z;
        System.out.println("Before Java 8");
        z = x*y;
        System.out.println(z);
        System.out.println("After Java 8");
        try{
            z = Math.multiplyExact(x,y);
        }catch (ArithmeticException ex){
            System.out.println(ex.getMessage());
            z = Math.multiplyExact((long)x,(long)y);
            System.out.println("z :" + z);

        }
        if(z instanceof Long){
            System.out.println("\n yuuuup z is long");
        }

    }


}
