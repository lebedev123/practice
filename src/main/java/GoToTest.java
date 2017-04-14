/**
 * Created by dos on 13.11.2016.
 */
public class GoToTest {
    public static void main(String[] args) {
        int i = 0;

        for (; i < 10; i++) {
            System.out.println("i=" + i);
            if (i == 2) {
                System.out.println("continue");
                continue;
            }
            if (i == 3) {
                System.out.println("break");
                i++;
                break;
            }
            for (int k = 0; k < 5; k++) {
                System.out.println("inner");
            }
        }
    }

}

