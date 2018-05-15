import java.util.Arrays;
import java.util.Scanner;

public class ExtractBitFromInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int number = input[0];
        int index = input[1];

        number = number >> index;

        int numberAtIndex = number & 1;

        System.out.println(numberAtIndex);
    }
}
