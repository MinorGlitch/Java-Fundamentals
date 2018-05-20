import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArguments = scanner.nextLine().split("\\s+");

        int numbersCount = Integer.parseInt(inputArguments[0]);

        int elementsToPop = Integer.parseInt(inputArguments[1]);

        int elementToFind = Integer.parseInt(inputArguments[2]);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numbersCount; i++) {
            stack.push(scanner.nextInt());
        }

        for (int i = 0; i < elementsToPop; i++) {
            stack.pop();
        }

        if (stack.size() == 0) {
            System.out.println(0);
            return;
        }

        if (stack.contains(elementToFind)) {
            System.out.println(true);
        } else {
            System.out.println(getMin(stack));
        }
    }

    private static int getMin(Deque<Integer> stack) {
        int min = Integer.MAX_VALUE;

        while (stack.size() != 0) {
            int stackNum = stack.pop();

            if (stackNum < min) {
                min = stackNum;
            }
        }

        return min;
    }
}
