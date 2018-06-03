import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Set<Integer> divisors = Arrays.stream(reader.readLine()
                .split("\\s+")).map(Integer::parseInt).collect(Collectors.toSet());

        List<Integer> validNums = new ArrayList<>();

        BiPredicate<Integer, Set<Integer>> isValid = (num, nums) -> {
            boolean valid = false;

            for (Integer validNum : nums) {
                if (num % validNum == 0) {
                    valid = true;
                } else {
                    valid = false;
                    break;
                }
            }

            return valid;
        };

        for (int i = 1; i <= n; i++) {
            if (isValid.test(i, divisors)) {
                validNums.add(i);
            }
        }

        validNums.forEach(num -> System.out.print(num + " "));
    }
}
