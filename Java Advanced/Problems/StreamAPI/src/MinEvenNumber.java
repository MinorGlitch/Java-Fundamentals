import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class MinEvenNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] values = reader.readLine().split("\\s+");

        Optional<Double> minEven = Stream.of(values)
                .filter(x -> !x.isEmpty())
                .map(Double::valueOf)
                .filter(x -> x % 2 == 0)
                .min((x, y) -> x.compareTo(y));

        if (minEven.isPresent()) {
            System.out.printf("%1$.2f", minEven.get());
        } else {
            System.out.println("No match");
        }
    }
}
