import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> input = new ArrayDeque<>();

        Collections.addAll(input, scanner.nextLine().split("\\s+"));

        Deque<String> outputQueue = new ArrayDeque<>();
        Deque<String> operatorStack = new ArrayDeque<>();

        while (input.size() != 0) {
            String token = input.poll();

            if (isInteger(token)) {
                outputQueue.offer(token);
            } else if (isLeftBracket(token)) {
                operatorStack.push(token);
            } else if (isRightBracket(token)) {
                String operator = operatorStack.pop();

                while (true) {
                    if (operator.equals("(")) {
                        if (operatorStack.size() != 0) {
                            outputQueue.offer(operatorStack.pop());
                        }
                        break;
                    }

                    outputQueue.add(operator);
                    operator = operatorStack.pop();
                }
            } else if (isOperator(token)) {
                String topOfStack = null;

                if (operatorStack.size() != 0) {
                    topOfStack = operatorStack.peek();
                }
                operatorStack.push(token);

                while (true) {
                    if (operatorStack.size() > 1) {
                        if (hasHigherPrecedence(topOfStack, token) && isOperator(topOfStack)) {
                            topOfStack = operatorStack.pop();
                            outputQueue.offer(topOfStack);
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }

                    if (operatorStack.size() != 0) {
                        topOfStack = operatorStack.peek();
                    }

                    if (operatorStack.size() == 0) {
                        break;
                    }
                }
            } else if (isVariable(token)) {
                outputQueue.offer(token);
            }
        }

        while (operatorStack.size() != 0) {
            outputQueue.offer(operatorStack.pop());
        }

        System.out.println(String.join(" ", outputQueue));
    }

    private static boolean isVariable(String token) {
        return token.charAt(0) >= 97 && token.charAt(0) <= 122;
    }

    private static boolean hasHigherPrecedence(String topOfStack, String token) {
        if (topOfStack.equals("/") || topOfStack.equals("*") && token.equals("/") || token.equals("*")) {
            return true;
        } else if ((topOfStack.equals("+") || topOfStack.equals("-")) && (token.equals("+") || token.equals("-"))) {
            return true;
        } else if (topOfStack.equals("+") || topOfStack.equals("-") && (token.equals("/") || token.equals("*"))) {
            return false;
        } else if (topOfStack.equals("*") || topOfStack.equals("/") && (token.equals("+") || token.equals("-"))) {
            return true;
        }

        return false;
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("*") || token.equals("/") || token.equals("-");
    }

    private static boolean isLeftBracket(String token) {
        return token.equals("(");

    }

    private static boolean isRightBracket(String token) {
        return token.equals(")");

    }

    private static boolean isInteger(String token) {
        try {
            int number = Integer.parseInt(token);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
