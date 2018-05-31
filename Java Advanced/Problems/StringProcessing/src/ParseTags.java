import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();

        while (text.contains("<upcase>")) {
            int start = text.indexOf("<upcase>");
            int end = text.indexOf("</upcase>");

            String textToReplace = text.substring(start + 8, end);

            text = text.replaceFirst("<upcase>", "");
            text = text.replaceFirst("</upcase>", "");
            text = text.replaceFirst(textToReplace, textToReplace.toUpperCase());
        }

        System.out.println(text);
    }
}
