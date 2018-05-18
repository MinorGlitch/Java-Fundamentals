import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitByWordCasing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lowerCase = new ArrayList<>();
        List<String> upperCase = new ArrayList<>();
        List<String> mixedCase = new ArrayList<>();

        String[] words = scanner.nextLine().split("[,;:.!()\\[\\]\"'/\\\\ ]");

        for (String word : words) {
            if (word.length() != 0) {
                if (isLowerCase(word)) {
                    lowerCase.add(word);
                } else if (isUpperCase(word)) {
                    upperCase.add(word);
                } else {
                    mixedCase.add(word);
                }
            }
        }

        System.out.println("Lower-case: " + String.join(", ", lowerCase));
        System.out.println("Mixed-case: " + String.join(", ", mixedCase));
        System.out.println("Upper-case: " + String.join(", ", upperCase));
    }

    private static boolean isUpperCase(String word) {
        for (char ch : word.toCharArray()) {
            if (ch < 65 || ch > 90) {
                return false;
            }
        }

        return true;
    }

    private static boolean isLowerCase(String word) {
        for (char ch : word.toCharArray()) {
            if (ch < 97 || ch > 122) {
                return false;
            }
        }

        return true;
    }
}
