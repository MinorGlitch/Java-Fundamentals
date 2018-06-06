import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class FirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.asList(reader.readLine().split(" "));
        String[] startingLetters = reader.readLine().split(" ");

        Optional<String> firstMatch = names.stream()
                .sorted()
                .filter(name -> {
                    for (String startingLetter : startingLetters) {
                        if (String.valueOf(name.charAt(0)).equalsIgnoreCase(startingLetter)) {
                            return true;
                        }
                    }
                    return false;
                })
                .findFirst();

        if (firstMatch.isPresent()) {
            System.out.println(firstMatch.get());
        } else {
            System.out.println("No match");
        }
    }
}
