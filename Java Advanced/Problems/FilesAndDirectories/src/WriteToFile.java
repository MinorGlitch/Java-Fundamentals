import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {
        String pathToFile = "./input.txt";
        String pathToOutput = "./output.txt";

        Set<Integer> excludedCharacters = new HashSet<>();

        Collections.addAll(excludedCharacters, 33, 44, 46, 63);

        try (FileInputStream fis = new FileInputStream(pathToFile);
             FileOutputStream fos = new FileOutputStream(pathToOutput)) {
            int oneByte = fis.read();

            while (oneByte >= 0) {
                if (!excludedCharacters.contains(oneByte)) {
                    fos.write(oneByte);
                }

                oneByte = fis.read();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
