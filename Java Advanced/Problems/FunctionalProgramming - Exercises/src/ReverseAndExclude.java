import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine()
                .split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        Collections.reverse(numbers);

        int keyNum = Integer.parseInt(reader.readLine());

        numbers.removeIf(n -> n % keyNum == 0);

        numbers.forEach(n -> System.out.print(n + " "));
    }
}
