import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Pair<String, Integer>> studentsData = new ArrayList<>();

        String line = reader.readLine();

        while (!line.equals("END")) {
            String[] tokens = line.split(" ");

            String name = tokens[0] + " " + tokens[1];

            int age = Integer.valueOf(tokens[2]);

            studentsData.add(new Pair<>(name, age));

            line = reader.readLine();
        }

        studentsData.stream().filter(x -> x.getValue() >= 18 && x.getValue() <= 24)
                .forEach(x -> System.out.printf("%1$s %2$d%n", x.getKey(), x.getValue()));
    }
}
