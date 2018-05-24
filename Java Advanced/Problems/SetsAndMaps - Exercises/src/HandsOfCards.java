import java.util.*;

public class HandsOfCards {

    private static Map<String, Set<String>> deck = new LinkedHashMap<>();

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

            line = scanner.nextLine();
        }

        printPlayers();
    }

    private static void printPlayers() {
        for (Map.Entry<String, Set<String>> playerEntry : deck.entrySet()) {
            System.out.printf("%s: %d%n", playerEntry.getKey(), calculateScore(playerEntry.getValue()));
        }
    }

    private static int calculateScore(Set<String> value) {
        int sum = 0;

        int multiplyPower = 0;
        int multiplyType = 0;

        for (String card : value) {
            char power = card.charAt(0);
            char type = card.charAt(1);
            if (power == '1') {
                type = card.charAt(2);
            }

            switch (power) {
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    multiplyPower = Character.getNumericValue(power);
                    break;
                case '1':
                    multiplyPower = 10;
                    break;
                case 'J':
                    multiplyPower = 11;
                    break;
                case 'Q':
                    multiplyPower = 12;
                    break;
                case 'K':
                    multiplyPower = 13;
                    break;
                case 'A':
                    multiplyPower = 14;
                    break;
            }

            switch (type) {
                case 'S':
                    multiplyType = 4;
                    break;
                case 'H':
                    multiplyType = 3;
                    break;
                case 'D':
                    multiplyType = 2;
                    break;
                case 'C':
                    multiplyType = 1;
                    break;
            }


            sum += multiplyPower * multiplyType;
            multiplyPower = 0;
            multiplyType = 0;
        }

        return sum;
    }

    private static void addCardsToPlayer(String name, String[] currentDeck) {
        for (String card : currentDeck) {
            deck.get(name).add(card.trim());
        }
    }
}
