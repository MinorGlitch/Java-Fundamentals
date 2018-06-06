import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindAndSumIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] values = reader.readLine().split(" ");

        OptionalInt sum = Stream.of(values)
                .filter(x -> !x.isEmpty())
                .filter(x -> x.matches("-?\\d+"))
                .mapToInt(Integer::parseInt)
                .reduce((x, y) -> x + y);

        if (sum.isPresent()) {
            System.out.println(sum.getAsInt());
        } else {
            System.out.println("No match");
        }
    }
}
