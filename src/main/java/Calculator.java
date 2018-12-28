public class Calculator {
    int calls;

    public int getCalls() {
        return calls;
    }

    public long factorial(int number) {
        calls++;

        if (number < 0)
            throw new IllegalArgumentException();

        long result = 1;
        if (number > 1) {
            for (int i = 1; i <= number; i++)
                result = result * i;
        }

        return result;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.plus(1,2));
    }
    public long plus(int num1, int num2) {
        calls++;
        return num1 + num2;
    }

}
