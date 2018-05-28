import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String pathToInput = "./input.txt";
        String pathToOutput = "./output.txt";


        try (Scanner scanner = new Scanner(new FileInputStream(pathToInput));
             PrintWriter out = new PrintWriter(pathToOutput)) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    out.println(scanner.nextInt());
                }

                scanner.next();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
