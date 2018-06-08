import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BoundedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] bounds = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int lowerBound = bounds[0];
        int upperBound = bounds[1];

        List<Integer> numbers = Stream.of(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .filter(n -> n >= lowerBound && n <= upperBound || (n >= upperBound && n <= lowerBound))
                .collect(Collectors.toList());

        numbers.forEach(x -> System.out.print(x + " "));
    }
}
