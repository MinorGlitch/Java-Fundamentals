import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("(?<=\\s|^)[A-Za-z]+([-.]\\w*)*@[A-Za-z]+([-.]\\w*)*(\\.[a-z]+)");

        String line = reader.readLine();

        List<String> validEmails = new ArrayList<>();

        while (!line.equals("end")) {
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                validEmails.add(matcher.group());
            }

            line = reader.readLine();
        }

        validEmails.forEach(System.out::println);
    }
}
