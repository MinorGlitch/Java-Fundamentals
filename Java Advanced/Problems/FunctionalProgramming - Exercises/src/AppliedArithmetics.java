import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Long> numbers = Arrays.stream(reader.readLine()
                .split(" ")).map(Long::parseLong).collect(Collectors.toList());

        BiConsumer<List<Long>, String> alterList = (nums, operation) -> {
            switch (operation) {
                case "add":
                    for (int i = 0; i < nums.size(); i++) {
                        long num = nums.get(i);
                        nums.set(i, num + 1);
                    }
                    break;
                case "multiply":
                    for (int i = 0; i < nums.size(); i++) {
                        long num = nums.get(i);
                        nums.set(i, num * 2);
                    }
                    break;
                case "subtract":
                    for (int i = 0; i < nums.size(); i++) {
                        long num = nums.get(i);
                        nums.set(i, num - 1);
                    }
                    break;
                default:
                    nums.forEach(n -> System.out.print(n + " "));
                    System.out.println();
                    break;
            }
        };

        String line = reader.readLine();

        while (!line.equals("end")) {
            alterList.accept(numbers, line);
            line = reader.readLine();
        }
    }
}
