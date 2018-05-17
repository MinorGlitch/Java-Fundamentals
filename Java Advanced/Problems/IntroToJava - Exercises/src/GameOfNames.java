import java.util.Scanner;

public class GameOfNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        String winnerName = null;
        int winnerScore = Integer.MIN_VALUE;

        for (int i = 0; i < count; i++) {
            String currentName = scanner.nextLine();
            int initialScore = Integer.parseInt(scanner.nextLine());

            for (char letter : currentName.toCharArray()) {
                if (letter % 2 == 0) {
                    initialScore += letter;
                } else {
                    initialScore -= letter;
                }
            }

            if (initialScore > winnerScore) {
                winnerName = currentName;
                winnerScore = initialScore;
            }
        }

        System.out.printf("The winner is %s - %d points", winnerName, winnerScore);
    }
}
