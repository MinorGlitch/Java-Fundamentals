import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfAllValues {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern keyPattern = Pattern.compile("^([a-zA-Z_]+)\\d+.*?\\d+([a-zA-Z_]+)*$");

        String keys = reader.readLine();
        String text = reader.readLine();

        Matcher keyMatcher = keyPattern.matcher(keys);

        String start = null;
        String end = null;

        if (keyMatcher.find()) {
            start = keyMatcher.group(1);
            end = keyMatcher.group(2);
        }

        if (start == null || end == null) {
            System.out.println("<p>A key is missing</p>");
            return;
        }

        Pattern textPattern = Pattern.compile(Pattern.quote(start) + "(\\d*(?:\\.\\d+)?)" + Pattern.quote(end));

        Matcher matcher = textPattern.matcher(text);

        double sum = 0;

        while (matcher.find() && !matcher.group(1).isEmpty()) {
            sum += Double.valueOf(matcher.group(1));

        }

        if (sum != 0) {
            if (sum == (int) sum) {
                System.out.printf("<p>The total value is: <em>%1$d</em></p>", (int) sum);
            } else {
                System.out.printf("<p>The total value is: <em>%1$.2f</em></p>", sum);
            }
        } else {
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        }
    }
}
