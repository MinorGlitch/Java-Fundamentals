import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String keyword = reader.readLine();

        String textSentences = reader.readLine();

        Pattern pattern = Pattern.compile("([A-Z][\\w\\W]*?\\b" + keyword + "\\b[\\w\\W]*?[.!?])");

        List<String> validSentences = new ArrayList<>();

        Matcher matcher = pattern.matcher(textSentences);

        while (matcher.find()) {
            validSentences.add(matcher.group().trim());
        }

        validSentences.forEach(System.out::println);
    }
}
