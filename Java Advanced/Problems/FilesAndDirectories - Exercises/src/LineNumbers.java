import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LineNumbers {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("./resources/inputLineNumbers.txt"));
        PrintWriter writer = new PrintWriter("./resources/output.txt")) {
            String line = reader.readLine();

            int lineCount = 1;

            while (line != null) {
                String indexedLine = addLineNumber(line, lineCount++);

                writer.println(indexedLine);

                line = reader.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static String addLineNumber(String line, int lineCount) {
        return String.format("%d. %s", lineCount, line);
    }
}
