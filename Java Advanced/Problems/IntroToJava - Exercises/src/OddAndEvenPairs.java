import java.util.Arrays;
import java.util.Scanner;

public class OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        if (input.length % 2 != 0) {
            System.out.println("invalid length");
            return;
        }

        for (int i = 1; i < input.length; i += 2) {
            int currentNumber = input[i];
            int previousNumber = input[i - 1];

            String numbersType = "different";

            if (currentNumber % 2 == 0 && previousNumber % 2 == 0) {
                numbersType = "both are even";
            } else if (currentNumber % 2 != 0 && previousNumber % 2 != 0) {
                numbersType = "both are odd";
            }

            System.out.printf("%d, %d -> %s%n", previousNumber, currentNumber, numbersType);
        }
    }
}
