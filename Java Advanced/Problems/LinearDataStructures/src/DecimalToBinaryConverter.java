import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        Deque<Integer> binaryNum = new ArrayDeque<>();

        if (num == 0) {
            System.out.println("0");
            return;
        }

        while (num != 0) {
            binaryNum.push(num % 2);
            num /= 2;
        }

        while (binaryNum.size() > 0) {
            System.out.print(binaryNum.pop());
        }
    }
}
