import java.util.*;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] infixArgs = scanner.nextLine().split(" ");

        System.out.println(convertToPostFix(infixArgs));
    }

    private static String convertToPostFix(String[] infixArgs) {
        Deque<String> tokenStack = new ArrayDeque<>();

        Deque<String> outputQueue = new ArrayDeque<>();

        for (String operand : infixArgs) {
            if (isOperand(operand)) {
                outputQueue.offer(operand);
            } else if (operand.equals("(")) {
                tokenStack.push(operand);
            } else if (operand.equals(")")) {
                while (!tokenStack.isEmpty() && !tokenStack.peek().equals("(")) {
                    outputQueue.offer(tokenStack.pop());
                }

                if (tokenStack.size() != 0) {
                    tokenStack.pop();
                }
            } else {
                if (!tokenStack.isEmpty() && getPrecedence(operand) <= getPrecedence(tokenStack.peek())) {
                    outputQueue.offer(tokenStack.pop());
                }
                tokenStack.push(operand);
            }
        }

        while (!tokenStack.isEmpty()) {
            outputQueue.offer(tokenStack.pop());
        }

        return String.join(" ", outputQueue);
    }

    private static int getPrecedence(String operand) {
        switch (operand) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
        }

        return -1;
    }

//    private static boolean isOperator(String operand) {
//        return operand.equals("+") || operand.equals("-") || operand.equals("/") || operand.equals("*");
//    }

    private static boolean isOperand(String operand) {
        if (operand.charAt(0) >= 97 && operand.charAt(0) <= 122) {
            return true;
        }

        try {
            int num = Integer.parseInt(operand);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
