import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SumLines {
    public static void main(String[] args) {
        Path pathToInput = Paths.get("./resources/input.txt");

        try (BufferedReader reader = Files.newBufferedReader(pathToInput)) {
            String line = reader.readLine();
            while (line != null) {
                System.out.println(getLineSum(line));

                line = reader.readLine();
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static int getLineSum(String line) {
        int sum = 0;

        for (int i = 0; i < line.length(); i++) {
            sum += line.charAt(i);

        }

        return sum;
    }
}
