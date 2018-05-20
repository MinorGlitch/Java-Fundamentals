import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> calcStack = new ArrayDeque<>();

        Collections.addAll(calcStack, scanner.nextLine().split(" "));

        while (calcStack.size() > 1) {
            int firstNum = Integer.valueOf(calcStack.pop());
            String operator = calcStack.pop();
            int secondNum = Integer.valueOf(calcStack.pop());


            if (operator.equals("+")) {
                calcStack.push(String.valueOf(firstNum + secondNum));
            } else {
                calcStack.push(String.valueOf(firstNum - secondNum));

            }
        }

        System.out.println(calcStack.peek());
    }
}
