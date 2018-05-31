import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Pattern pattern = Pattern.compile("(<.*?>)");


        List<String> tags = new ArrayList<>();

        while (!input.equals("END")) {
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                tags.add(matcher.group(1));
            }

            input = reader.readLine();
        }

        System.out.println(String.join("\n", tags));
    }
}
