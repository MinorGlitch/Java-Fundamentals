import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File workingDirectory = new File("./Files-and-Streams");

        File[] allFiles = workingDirectory.listFiles();

        for (File file : allFiles) {
            if (file.isDirectory()) {
                continue;
            }
            System.out.printf("%s: %s%n", file.getName(), file.length());
        }
    }
}
