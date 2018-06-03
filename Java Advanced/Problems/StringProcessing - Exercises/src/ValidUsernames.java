import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String names = reader.readLine();

        List<String> matches = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\b[a-z][a-zA-Z0-9_]{2,24}\\b");

        Matcher matcher = pattern.matcher(names);

        while (matcher.find()) {
            matches.add(matcher.group());
        }

        String[] pairs = new String[2];

        int lastPairSum = Integer.MIN_VALUE;

        for (int i = 1; i < matches.size(); i++) {
            int sum = matches.get(i).length() + matches.get(i - 1).length();

            if (sum > lastPairSum) {
                pairs[0] = matches.get(i - 1);
                pairs[1] = matches.get(i);
                lastPairSum = sum;
            }
        }

        for (String pair : pairs) {
            System.out.println(pair);
        }
    }
}
