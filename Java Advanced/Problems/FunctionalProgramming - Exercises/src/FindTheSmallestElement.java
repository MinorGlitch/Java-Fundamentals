import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine()
                .split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> getSmallestElementIndex = nums -> {
            int min = Integer.MAX_VALUE;
            int index = 0;

            for (int i = 0; i < nums.size(); i++) {
                int currentNum = nums.get(i);

                if (currentNum <= min) {
                    min = currentNum;
                    index = i;
                }
            }

            return index;
        };

        System.out.println(getSmallestElementIndex.apply(numbers));
    }
}
