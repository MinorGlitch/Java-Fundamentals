import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstString = scanner.next("\\w+");
        String secondString = scanner.next("\\w+");

        int shorterString = Math.min(firstString.length(), secondString.length());

        int sum = 0;

        for (int i = 0; i < shorterString; i++) {

            char firstStringCurrentChar = firstString.charAt(i);
            char secondStringCurrentChar = secondString.charAt(i);

            sum += firstStringCurrentChar * secondStringCurrentChar;

            if (i == shorterString - 1 && firstString.length() != secondString.length()) {
                if (firstString.length() > shorterString) {
                    sum = sumRemainingCharacters(sum, firstString, i);
                } else {
                    sum = sumRemainingCharacters(sum, secondString, i);
                }

                break;
            }
        }

        System.out.println(sum);
    }

    private static int sumRemainingCharacters(int currentSum, String longerString, int stringIndex) {
        for (int i = stringIndex + 1; i < longerString.length(); i++) {
            currentSum += longerString.charAt(i);
        }

        return currentSum;
    }
}
