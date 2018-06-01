import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceATag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result = new StringBuilder();

        String line = reader.readLine();

        Pattern pattern = Pattern.compile("(<a) href=.*?(>)\\s*.*(<\\/a>)");

        while (!line.equals("END")) {
            result.append(line).append(System.lineSeparator());

            line = reader.readLine();
        }

        String resultStr = result.toString();

        Matcher matcher = pattern.matcher(resultStr);

        while (matcher.find()) {
            String allGroups = matcher.group(0);

            String openingATag = matcher.group(1);
            String closingATag = matcher.group(2);
            String endTag = matcher.group(3);

            String replacement = allGroups;

            replacement = replacement.replaceFirst(openingATag, "[URL")
                    .replaceFirst(closingATag, "]").replaceFirst(endTag, "[/URL]");

            resultStr = resultStr.replace(allGroups, replacement);

        }

        System.out.println(resultStr);
    }
}
