import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHyperlinks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("<a[^>]+?href\\s*=\\s*(\".*?\"|'.*?'|.*?)[\\s>]");

        String line = reader.readLine();

        List<String> hrefs = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        while (!line.equals("END")) {

            sb.append(line).append(System.lineSeparator());

            line = reader.readLine();
        }

        Matcher matcher = pattern.matcher(sb.toString());

        while (matcher.find()) {
            hrefs.add(matcher.group(1));
        }

        hrefs.forEach(href -> {
            if (href.startsWith("\"") || href.startsWith("'")) {
                System.out.println(href.substring(1, href.length() - 1));
            } else {
                System.out.println(href);
            }
        });
    }
}
