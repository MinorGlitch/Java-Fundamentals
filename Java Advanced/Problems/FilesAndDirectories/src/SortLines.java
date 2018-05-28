import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) {
        Path input = Paths.get("./secondInput.txt");
        Path output = Paths.get("./output.txt");

        try {
            Set<String> lines = new TreeSet<>(Files.readAllLines(input));
            Files.write(output, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
