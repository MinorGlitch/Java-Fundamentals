import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.regex.Pattern;

public class Internships {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<String> candidates = new ArrayDeque<>();
        Deque<String> problems = new ArrayDeque<>();

        int n = Integer.valueOf(reader.readLine());
        int m = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            problems.push(reader.readLine());
        }

        for (int i = 0; i < m; i++) {
            String name = reader.readLine();

            if (name.matches("[A-Z][a-z]+ [A-Z][a-z]+")) {
                candidates.addLast(name);
            }
        }

        while (true) {
            if (problems.isEmpty()) {
                System.out.println(String.join(", ", candidates));
                break;
            }

            if (candidates.size() == 1) {
                System.out.printf("%s gets the job!%n", candidates.pop());
                break;
            }

            String candidate = candidates.peek();
            String problem = problems.peek();

            int candidateSum = sumChars(candidate);
            int problemSum = sumChars(problem);

            if (candidateSum > problemSum) {
                problem = problems.pop();
                candidates.addLast(candidates.pop());
                System.out.printf("%s solved %s.%n", candidate, problem);
            } else {
                problems.addLast(problems.pop());
                candidates.remove(candidates.pop());
                System.out.printf("%s failed %s.%n", candidate, problem);
            }
        }

    }

    private static int sumChars(String candidate) {
        int sum = 0;
        for (char c : candidate.toCharArray()) {
            sum += c;

        }

        return sum;
    }
}
