import java.util.Scanner;

/**
 * Created by dos on 13.11.2016.
 */
public class WhileTest {
    //Fibonacci
    public static void Fibonacci(int a) {
        if (a == 0) {
            System.out.print("nothing");
        } else if (a == 1) {
            System.out.print("1");
        } else {
            int[] s1 = new int[a];
            s1[0] = s1[1] = 1;
            System.out.print(s1[0] + " " + s1[1] + " ");
            for (int i = 2; i < a; i++) {
                s1[i] = s1[i - 1] + s1[i - 2];
                System.out.print(s1[i] + " ");
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            Fibonacci(a);
        }
    }
}
