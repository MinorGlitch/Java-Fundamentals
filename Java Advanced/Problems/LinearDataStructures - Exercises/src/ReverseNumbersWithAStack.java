import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\s+");

        Deque<Integer> stack = new ArrayDeque<>();

        for (String number : line) {
            stack.push(Integer.parseInt(number));
        }

        while (stack.size() != 0) {
            System.out.printf("%d ", stack.pop());
        }
    }
}
