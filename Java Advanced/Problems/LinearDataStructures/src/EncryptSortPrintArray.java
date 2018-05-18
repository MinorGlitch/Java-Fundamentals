import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortPrintArray {

    private static String[] vowels = new String[]{"a", "e", "o", "u", "i"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        int[] encryptedNames = new int[count];

        for (int i = 0; i < count; i++) {
            String name = scanner.nextLine();

            int encrypted = 0;


            for (char ch : name.toCharArray()) {
                if (isVowel(String.valueOf(ch))) {
                    encrypted += ch * name.length();
                } else {
                    encrypted += ch / name.length();
                }
            }

            encryptedNames[i] = encrypted;
        }

        Arrays.sort(encryptedNames);

        for (int name : encryptedNames) {
            System.out.println(name);
        }
    }

    private static boolean isVowel(String ch) {
        for (String vowel : vowels) {
            if (vowel.equals(ch.toLowerCase())) {
                return true;
            }
        }

        return false;
    }
}
