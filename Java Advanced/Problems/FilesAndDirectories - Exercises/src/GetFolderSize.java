import java.io.*;

public class GetFolderSize {
    public static void main(String[] args) {
        File folder = new File("./resources/Exercises Resources/");

        try (PrintWriter writer = new PrintWriter("./resources/output.txt")) {
            int sum = 0;

            for (File file : folder.listFiles()) {
                if (!file.isDirectory()) {
                    sum += file.length();
                }
            }

            writer.printf("Folder size: %d%n", sum);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
