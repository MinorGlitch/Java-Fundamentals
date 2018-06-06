import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TakeTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> values = Arrays.asList(reader.readLine().split(" "));

        List<Integer> numbers = values.stream().map(Integer::parseInt).collect(Collectors.toList());

        Stream<Integer> numbersStream = numbers.stream()
                .distinct()
                .filter(n -> n >= 10 && n <= 20).limit(2);

        numbersStream.forEach(s -> System.out.print(s + " "));
    }
}
