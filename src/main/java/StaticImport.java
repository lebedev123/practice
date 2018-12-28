import static java.lang.System.out;

public class StaticImport {
    public static void main(String[] args) {
        int a  = 0xA;
        int b  = 0x2;
        int c = a & b;
        int d = a | b;
        System.out.println(Integer.toBinaryString(c));
        System.out.println(Integer.toBinaryString(d));
    }
}
