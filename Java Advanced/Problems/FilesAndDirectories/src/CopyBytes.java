import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) {
        String pathToInput = "./input.txt";
        String pathToOutput = "./output.txt";


        try (FileInputStream fis = new FileInputStream(pathToInput);
             FileOutputStream fos = new FileOutputStream(pathToOutput)) {

            int bytes = fis.read();

            while (bytes >= 0) {
                String stringBytes = String.valueOf(bytes);

                if (bytes == 32 || bytes == 10) {
                    fos.write(bytes);
                } else {
                    for (int i = 0; i < stringBytes.length(); i++) {
                        fos.write(stringBytes.charAt(i));
                    }
                }

                bytes = fis.read();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
