import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] lineArgs = reader.readLine().split(", ");

        Function<String[], int[]> parseInput = line -> {
            int[] output = new int[line.length];

            for (int i = 0; i < line.length; i++) {
                output[i] = Integer.parseInt(line[i]);
            }

            return output;
        };

        int[] parsed = parseInput.apply(lineArgs);

        Function<int[], Integer> sumNumbers = nums -> {
            int sum = 0;

            for (int num : nums) {
                sum += num;
            }

            return sum;
        };

        System.out.println("Count = " + parsed.length);
        System.out.println("Sum = " + sumNumbers.apply(parsed));
    }
}
