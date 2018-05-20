import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArguments = scanner.nextLine().split("\\s+");

        int numbersCount = Integer.parseInt(inputArguments[0]);

        int elementsToAdd = Integer.parseInt(inputArguments[1]);

        int elementToFind = Integer.parseInt(inputArguments[2]);

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numbersCount; i++) {
            queue.offer(scanner.nextInt());
        }

        for (int i = 0; i < elementsToAdd; i++) {
            queue.poll();
        }

        if (queue.size() == 0) {
            System.out.println(0);
            return;
        }

        if (queue.contains(elementToFind)) {
            System.out.println(true);
        } else {
            System.out.println(getMin(queue));
        }
    }

    private static int getMin(Deque<Integer> queue) {
        int min = Integer.MAX_VALUE;

        while (queue.size() != 0) {
            int stackNum = queue.poll();

            if (stackNum < min) {
                min = stackNum;
            }
        }

        return min;
    }
}
