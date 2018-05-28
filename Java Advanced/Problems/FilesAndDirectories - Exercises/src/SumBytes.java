import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SumBytes {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("./resources/input.txt"))) {
            List<String> lines = new ArrayList<>();

            String line = reader.readLine();

            while (line != null) {
                lines.add(line);

                line = reader.readLine();
            }

            int sum = sumLines(lines);

            System.out.println(sum);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static int sumLines(List<String> lines) {
        int sum = 0;

        for (String line : lines) {
            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);
            }
        }

        return sum;
    }
}
