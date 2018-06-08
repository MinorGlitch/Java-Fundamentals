import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> studentNames = new ArrayList<>();

        String line = reader.readLine();

        Pattern pattern = Pattern.compile("(\\w+ \\w+) 2");

        while (!line.equals("END")) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                studentNames.add(matcher.group(1));
            }

            line = reader.readLine();
        }

        Comparator<String> sort = (a, b) -> {
            return a.split(" ")[0].compareTo(b.split(" ")[0]);
        };

        studentNames.stream().sorted(sort).forEach(System.out::println);
    }
}
