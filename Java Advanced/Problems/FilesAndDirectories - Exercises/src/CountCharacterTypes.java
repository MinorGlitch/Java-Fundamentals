import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CountCharacterTypes {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("./resources/input.txt"));
             PrintWriter writer = new PrintWriter("./resources/output.txt")) {

            int[] counter = new int[3];

            String line = reader.readLine();


            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char currentChar = line.charAt(i);

                    if (currentChar == ' ') {
                        continue;
                    }

                    if (currentChar == 'a' || currentChar == 'e' || currentChar == 'o' || currentChar == 'u'
                            || currentChar == 'i') {
                        counter[0]++;
                    } else if (currentChar == '!' || currentChar == '.' || currentChar == ',' || currentChar == '?') {
                        counter[1]++;
                    } else {
                        counter[2]++;
                    }

                }

                line = reader.readLine();
            }

            writer.printf("Vowels: %d%n", counter[0]);
            writer.printf("Consonants: %d%n", counter[2]);
            writer.printf("Punctuation: %d%n", counter[1]);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
