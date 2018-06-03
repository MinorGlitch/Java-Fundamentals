import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Comparator<Integer> comparator = (first, second) -> {
            boolean firstIsEven = first % 2 == 0;
            boolean secondIsEven = second % 2 == 0;

            if (firstIsEven && !secondIsEven) {
                return -1;
            } else if (!firstIsEven && secondIsEven) {
                return 1;
            }

            return first - second;
        };

        numbers.sort(comparator);

        numbers.forEach(n -> System.out.print(n + " "));
    }
}
