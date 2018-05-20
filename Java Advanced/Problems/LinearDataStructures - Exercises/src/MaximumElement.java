import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(scanner.readLine());

        int max = Integer.MIN_VALUE;

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] params = scanner.readLine().split(" ");

            int command = Integer.parseInt(params[0]);

            if (command == 1) {
                int num = Integer.parseInt(params[1]);
                stack.push(num);

                if (num >= max) {
                    max = num;
                    maxStack.push(max);
                }
            } else if (command == 2) {
                int poppedNum = stack.pop();

                if (poppedNum == max) {
                    maxStack.pop();
                    if (maxStack.size() > 0) {
                        max = maxStack.peek();
                    } else {
                        max = Integer.MIN_VALUE;
                    }
                }
            } else {
                sb.append(String.valueOf(max)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
