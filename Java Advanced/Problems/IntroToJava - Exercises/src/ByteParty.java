import java.util.Arrays;
import java.util.Scanner;

public class ByteParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            int currentDecimal = Integer.parseInt(scanner.nextLine());

            numbers[i] = currentDecimal;
        }

        String input = scanner.nextLine();

        while (true) {
            if ("party over".equals(input)) {
                break;
            }

            int[] modificationArguments = Arrays.stream(input
                    .split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int command = modificationArguments[0];

            int column = modificationArguments[1];

            modifyNumber(numbers, command, column);

            input = scanner.nextLine();
        }

        for (int number : numbers) {
            System.out.println(number);
        }
    }

    private static void modifyNumber(int[] binaryNumbers, int command, int column) {
        for (int i = 0; i < binaryNumbers.length; i++) {

            switch (command) {
                case -1:
                    reverseBits(binaryNumbers, column, i);
                    break;
                case 0:
                    setBitsToZero(binaryNumbers, column);
                    break;
                case 1:
                    setBitsToOne(binaryNumbers, column);
                    break;
            }
        }
    }

    private static void setBitsToZero(int[] binaryNumbers, int column) {
        for (int i = 0; i < binaryNumbers.length; i++) {
            binaryNumbers[i] = binaryNumbers[i] & ~(1 << column);
        }
    }

    private static void setBitsToOne(int[] binaryNumbers, int column) {
        for (int i = 0; i < binaryNumbers.length; i++) {
            binaryNumbers[i] = binaryNumbers[i] | (1 << column);
        }
    }

    private static void reverseBits(int[] binaryNumbers, int column, int i) {
        int number = binaryNumbers[i];
        int numberAfterShift = number >> column;
        int firstBit = numberAfterShift & 1;

        if (firstBit == 0) {
            int mask = 1 << column;
            binaryNumbers[i] = number | mask;
        } else {
            int mask = ~(1 << column);
            binaryNumbers[i] = number & mask;
        }
    }
}
