import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> studentNames = new ArrayList<>();

        String line = reader.readLine();

        while (!line.equals("END")) {
            studentNames.add(line);
            line = reader.readLine();
        }

        studentNames.stream().filter((a) -> {
            String[] names = a.split(" ");

            return names[0].compareTo(names[1]) < 0;
        }).forEach(System.out::println);
    }
}
