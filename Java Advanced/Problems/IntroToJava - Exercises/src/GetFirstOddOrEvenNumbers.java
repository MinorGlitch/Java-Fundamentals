import java.util.Arrays;
import java.util.Scanner;

public class GetFirstOddOrEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String[] numbersCount = scanner.nextLine().split("\\s+");

        int numbersToGet = Integer.parseInt(numbersCount[1]);

        int iterationsCount = getIterationsCount(numbers.length, numbersToGet);

        String numberType = numbersCount[2];

        int numsPrinted = 0;

        for (int number : numbers) {
            if (iterationsCount == numsPrinted) {
                break;
            }

            switch (numberType) {
                case "odd":
                    if (number % 2 != 0) {
                        System.out.printf("%d ", number);
                        numsPrinted++;
                    }
                    break;
                case "even":
                    if (number % 2 == 0) {
                        System.out.printf("%d ", number);
                        numsPrinted++;
                    }
                    break;
            }
        }
    }

    private static int getIterationsCount(int length, int numbersToGet) {
        if (numbersToGet >= length) {
            return length;
        } else {
            return numbersToGet;
        }
    }
}
