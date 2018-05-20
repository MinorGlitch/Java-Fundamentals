import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParenthesis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> stack = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("");

        if (input.length % 2 != 0) {
            System.out.println("NO");
            return;
        }

        for (String s : input) {
            if (s.equals("{") || s.equals("[") || s.equals("(")) {
                stack.push(s);
            } else {
                if (stack.size() > 0) {
                    if (!isValidParentheses(stack.pop() + s)) {
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }

        System.out.println("YES");
    }

    private static boolean isValidParentheses(String parentheses) {
        return parentheses.equals("{}") || parentheses.equals("[]") || parentheses.equals("()");
    }
}
