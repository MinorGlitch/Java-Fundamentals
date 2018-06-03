import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] range = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int start = range[0];

        int end = range[1];

        String type = reader.readLine();

        Predicate<String> isOdd = t -> type.equals("odd");

        printNumbers(isOdd.test(type), start, end);
    }

    private static void printNumbers(boolean type, int start, int end) {
        if (type) {
            for (int i = start; i <= end; i++) {
                if (i % 2 != 0) {
                    System.out.print(i + " ");
                }
            }
        } else {
            for (int i = start; i <= end; i++) {
                if (i % 2 == 0) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
