import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine()
                .split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> getMin = nums -> {
            int min = Integer.MAX_VALUE;

            for (Integer num : nums) {
                if (num <= min) {
                    min = num;
                }
            }
            return min;
        };

        System.out.println(getMin.apply(numbers));
    }
}
