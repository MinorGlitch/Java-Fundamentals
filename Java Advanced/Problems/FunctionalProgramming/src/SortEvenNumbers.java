import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        numbers.removeIf(n -> n % 2 != 0);

        Consumer<List<Integer>> printNumbers = nums ->
                System.out.println(nums.toString().replaceAll("[\\[\\]]", ""));

        printNumbers.accept(numbers);

        numbers.sort(Integer::compareTo);

        printNumbers.accept(numbers);
    }
}
