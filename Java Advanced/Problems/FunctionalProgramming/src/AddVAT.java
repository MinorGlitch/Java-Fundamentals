import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Double> numbers = Arrays.stream(reader.readLine().split(", "))
                .map(Double::parseDouble).collect(Collectors.toList());

        Consumer<List<Double>> addVAT = nums -> {
            for (int i = 0; i < nums.size(); i++) {
                nums.set(i, nums.get(i) * 1.2);
            }
        };

        addVAT.accept(numbers);

        System.out.println("Prices with VAT:");
        numbers.forEach(num -> System.out.printf("%1$.2f%n", num));
    }
}
