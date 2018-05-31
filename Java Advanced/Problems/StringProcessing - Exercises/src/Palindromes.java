import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] text = reader.readLine().split("[,.?!\\s]+");

        Set<String> palindromes = new TreeSet<>();

        for (String word : text) {
            if (isPalindrome(word)) {
                palindromes.add(word);
            }
        }

        System.out.println(palindromes);
    }

    private static boolean isPalindrome(String word) {
        return word.equals(reversed(word));
    }

    private static String reversed(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}
