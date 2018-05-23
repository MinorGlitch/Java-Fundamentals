import java.util.*;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> occurrences = new TreeMap<>();

        String text = scanner.nextLine();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            occurrences.putIfAbsent(character, 0);
            occurrences.put(character, occurrences.get(character) + 1);
        }

        for (Map.Entry<Character, Integer> characterEntry : occurrences.entrySet()) {
            System.out.printf("%s: %d time/s%n", characterEntry.getKey(), characterEntry.getValue());
        }
    }
}
