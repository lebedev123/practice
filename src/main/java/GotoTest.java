public class GotoTest {
    public static void main(String[] args) {
        int a = 11;
        outer:
        while (a!=15) {
            System.out.println();
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i == 7) {
                    break outer;
                }
            }
            a++;
        }
    }
}
