import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String expression = scanner.nextLine();

        Deque<Integer> indexes = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                indexes.push(i);
            } else if (expression.charAt(i) == ')') {
                int startIndex = indexes.pop();
                String subExpression = expression.substring(startIndex, i + 1);
                System.out.println(subExpression);
            }
        }
    }
}
