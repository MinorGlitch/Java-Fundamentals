import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountSubstringOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        String pattern = reader.readLine().toLowerCase();

        int count = 0;

        for (int i = pattern.length(); i <= text.length(); i++) {
            String subStr = text.substring(i - pattern.length(), i).toLowerCase();

            if (subStr.equals(pattern)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
