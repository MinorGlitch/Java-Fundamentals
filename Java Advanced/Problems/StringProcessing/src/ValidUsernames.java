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

        Pattern pattern = Pattern.compile("(^[A-Za-z0-9-_]{3,16}$)");

        String input = reader.readLine();

        List<String> validUsernames = new ArrayList<>();

        while (!input.equals("END")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                validUsernames.add("valid");
            } else {
                validUsernames.add("invalid");
            }

            input = reader.readLine();
        }

        if (validUsernames.contains("valid")) {
            validUsernames.forEach(System.out::println);
        }
    }
}
