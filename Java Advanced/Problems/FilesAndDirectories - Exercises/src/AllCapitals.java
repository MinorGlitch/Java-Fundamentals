import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class AllCapitals {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("./resources/input.txt"));
             PrintWriter writer = new PrintWriter("./resources/output.txt")) {
            String line = reader.readLine();

            while (line != null) {
                writer.println(line.toUpperCase());

                line = reader.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
