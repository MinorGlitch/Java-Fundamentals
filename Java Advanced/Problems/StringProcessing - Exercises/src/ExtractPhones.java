import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPhones {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("^\\+359([ -])2\\1\\d{3}\\1\\d{4}$");

        List<String> validPhones = new ArrayList<>();

        String line = reader.readLine();

        while (!line.equals("end")) {
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                validPhones.add(matcher.group(0));
            }

            line = reader.readLine();
        }

        validPhones.forEach(System.out::println);
    }
}
