import java.util.*;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = new LinkedHashSet<>();
        Set<Integer> secondPlayer = new LinkedHashSet<>();

        fillPlayers(firstPlayer, secondPlayer, scanner);

        for (int i = 0; i < 50; i++) {
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                System.out.println(firstPlayer.isEmpty() ? "First player win!" : "Second player win!");
                return;
            }

            int firstPlayerNumber = firstPlayer.iterator().next();
            int secondPlayerNumber = secondPlayer.iterator().next();

            firstPlayer.remove(firstPlayerNumber);
            secondPlayer.remove(secondPlayerNumber);

            if (firstPlayerNumber >= secondPlayerNumber) {
                firstPlayer.add(firstPlayerNumber);
                firstPlayer.add(secondPlayerNumber);
            } else {
                secondPlayer.add(firstPlayerNumber);
                secondPlayer.add(secondPlayerNumber);
            }
        }

        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }

    private static void fillPlayers(Set<Integer> firstPlayer, Set<Integer> secondPlayer, Scanner scanner) {
        int[] firstPlayerNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] secondPlayerNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int number : firstPlayerNumbers) {
            firstPlayer.add(number);
        }

        for (int number : secondPlayerNumbers) {
            secondPlayer.add(number);
        }
    }
}
