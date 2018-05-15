import java.util.Arrays;
import java.util.Scanner;

public class AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        double averageSum = calcAverage(numbers);

        System.out.printf("%.2f", averageSum);
    }

    public static double calcAverage(double[] numbers) {
        int count = numbers.length;

        double sum = 0.0D;

        for (int i = 0; i < count; ++i) {
            sum += numbers[i];
        }

        sum /= count;
        return sum;
    }
}
