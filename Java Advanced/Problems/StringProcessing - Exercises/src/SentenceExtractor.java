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

        String[] textSentences = reader.readLine().split(" ");

        Pattern pattern = Pattern.compile("(?<=^| )" + keyword);

        List<String> validSentences = new ArrayList<>();

        for (String sentence : textSentences) {
            Matcher matcher = pattern.matcher(sentence);

            if (matcher.find()) {
                validSentences.add(sentence);
            }
        }

        validSentences.forEach(System.out::println);
    }
}
