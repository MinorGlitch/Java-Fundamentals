import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class ProductOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        BigInteger product = BigInteger.valueOf(1);

        int n = numbers[0];
        int m = numbers[1];

        for (int i = n; i <= m; ++i) {
            product = product.multiply(BigInteger.valueOf(i));
        }

        System.out.printf("product[%d..%d] = %d", n, m, product);
    }
}
