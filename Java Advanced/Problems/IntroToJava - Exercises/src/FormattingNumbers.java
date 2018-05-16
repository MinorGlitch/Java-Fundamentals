import java.text.DecimalFormat;
import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        String hexA = Integer.toHexString(a);

        String binaryA = Integer.toBinaryString(a);

        String formattedBinary = String.format("%10s", binaryA).replace(' ', '0');

        System.out.printf("|%s|%s|%s|%s|",
                String.format("%-10s", hexA.toUpperCase()),
                formattedBinary,
                String.format("%10.2f", b),
                String.format("%-10.3f", c));
    }
}
