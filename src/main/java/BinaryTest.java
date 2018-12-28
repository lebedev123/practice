public class BinaryTest {


    public static void main(String[] args) {
        int c = Integer.MAX_VALUE;
        System.out.println(c);
        System.out.println(Integer.toBinaryString(c));
        c <<= 1;
        System.out.println(c);
        System.out.println(Integer.toBinaryString(c));
        c >>= 2;
        System.out.println(c);
        System.out.println(Integer.toBinaryString(c));
        c = Integer.MIN_VALUE;
        System.out.println(c);
        System.out.println(Integer.toBinaryString(c));

        c >>>= 1;
        System.out.println(c);
        System.out.println(Integer.toBinaryString(c));

        c >>= 1;
        System.out.println(c);
        System.out.println(Integer.toBinaryString(c));

        c <<= 1;
        System.out.println(c);
        System.out.println(Integer.toBinaryString(c));
        A1 a = new A1();
        System.out.println(a.getA());
        a.A12(new Integer(12));
    }

}

class A1 {
    int a ;

    public int getA() {
        return a;
    }
    public A1() {
        System.out.println("A1()");
    }
    public void A12(int a){
        System.out.println(a);
    }

}

class B1 extends A1{
    int j;
    public B1() {
        System.out.println("B1()");
    }

    public B1(int j) {
        System.out.println("B (j)");
        this.j = j;
    }
}
