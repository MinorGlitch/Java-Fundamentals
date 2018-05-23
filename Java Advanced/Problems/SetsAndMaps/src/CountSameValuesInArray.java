import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CountSameValuesInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");

        Map<String, Integer> numbersCount = new HashMap<>();

        for (String number : numbers) {

            numbersCount.putIfAbsent(number, 0);
            numbersCount.put(number, numbersCount.get(number) + 1);
        }

        for (Map.Entry<String, Integer> numberSet : numbersCount.entrySet()) {
            System.out.printf("%s - %d times%n", numberSet.getKey(), numberSet.getValue());
        }
    }
}
