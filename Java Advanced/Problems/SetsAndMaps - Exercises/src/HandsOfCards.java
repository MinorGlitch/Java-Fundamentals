import java.util.*;

public class HandsOfCards {

    private static  Map<String, Set<String>> deck = new LinkedHashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        while (!line.equals("JOKER")) {
            String[] lineArgs = line.split(":");

            String name = lineArgs[0];

            String[] currentDeck = lineArgs[1].split(", ");

            if (!deck.containsKey(name)) {
                deck.put(name, new HashSet<>());
            }

            addCardsToPlayer(name, currentDeck);
        }

        printPlayers();
    }

    private static void printPlayers() {
        for (Map.Entry<String, Set<String>> playerEntry : deck.entrySet()) {
            System.out.printf("%s: %d", playerEntry.getKey(), calculateScore(playerEntry.getValue()));
        }
    }

    private static int calculateScore(Set<String> value) {
        for (String card : value) {

        }
    }

    private static void addCardsToPlayer(String name, String[] currentDeck) {
        for (String card : currentDeck) {
            deck.get(name).add(card);
        }
    }
}
