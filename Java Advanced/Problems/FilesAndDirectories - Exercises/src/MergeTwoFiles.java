import java.io.*;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String fileOneLocation = "./resources/Exercises Resources/inputOne.txt";

        try (PrintWriter writer = new PrintWriter("./resources/output.txt")) {

            BufferedReader reader = new BufferedReader(new FileReader(fileOneLocation));

            String line = reader.readLine();

            while (line != null) {
                writer.println(line);
                line = reader.readLine();
            }

            String fileTwoLocation = "./resources/Exercises Resources/inputTwo.txt";

            reader = new BufferedReader(new FileReader(fileTwoLocation));

            line = reader.readLine();

            while (line != null) {
                writer.println(line);
                line = reader.readLine();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
