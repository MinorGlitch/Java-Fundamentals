import java.util.Scanner;

public class ModifyABit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int position = scanner.nextInt();
        int bitValue = scanner.nextInt();

        int mask;
        int result;

        if (bitValue == 0) {
            mask = ~(1 << position);
            result = number & mask;
        } else {
            mask = 1 << position;
            result = number | mask;
        }

        System.out.println(result);
    }
}
