import java.util.Scanner;

/**
 * Created by dos on 13.11.2016.
 */
public class TestCase {
    public static void main(String[] args) {
        boolean i = false;
        while (i == false) {
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            switch (a) {
                case 1:
                    System.out.println("LUL 1");
                    break;
                case 2:
                    System.out.println("LUL 2");
                    break;
                default:
                    System.out.println("NOT A 1 or 2 GIGALUL");
            }
            if (a == 0) break;
        }
    }
}
