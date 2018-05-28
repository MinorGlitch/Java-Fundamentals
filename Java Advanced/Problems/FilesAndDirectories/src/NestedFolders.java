import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {
    public static void main(String[] args) {
        File workingDirectory = new File("./Files-and-Streams");

        Deque<File> fileDeque = new ArrayDeque<>();

        fileDeque.offer(workingDirectory);

        int count = 1;

        while (!fileDeque.isEmpty()) {
            File current = fileDeque.poll();

            File[] nestedFiles = current.listFiles();

            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    fileDeque.offer(nestedFile);
                    count++;
                }
            }

            System.out.println(current.getName());
        }

        System.out.println(count + " folders");
    }
}
