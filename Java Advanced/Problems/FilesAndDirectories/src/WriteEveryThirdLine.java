import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String pathToInput = "./input.txt";
        String pathToOutput = "./output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(pathToInput));
             PrintWriter out = new PrintWriter(new FileWriter(pathToOutput))) {

            int index = 1;

            String line = reader.readLine();

            while (line != null) {

                if (index++ % 3 == 0) {
                    out.println(line);
                }

                line = reader.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
