package leetCodePractise;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }

    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int one = 1;
        int two = 0;
        int fib = 0;
        for (int i=2; i<= n; i++) {

            fib = one + two;
            two = one;
            one = fib;
        }
        return fib;
    }
}
