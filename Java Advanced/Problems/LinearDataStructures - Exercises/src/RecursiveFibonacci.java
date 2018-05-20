import java.util.*;

public class RecursiveFibonacci {

    private static long[] memoization;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        memoization = new long[n + 2];

        System.out.println(fibonacci(n + 1));
    }

    private static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        if (memoization[n] != 0) {
            return memoization[n];
        }

            memoization[n] = fibonacci(n - 1) + fibonacci(n - 2);


        return memoization[n];
    }
}
