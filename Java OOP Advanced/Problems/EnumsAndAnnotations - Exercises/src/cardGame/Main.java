package cardGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Player first = new Player(reader.readLine());
        Player second = new Player(reader.readLine());

        Deck deck = new Deck();

        while (true) {
            if (!first.isHandEmpty() && !second.isHandEmpty()) {
                System.out.println(getWinner(first, second));
                return;
            }
            String[] cardArgs = reader.readLine().split(" of ");

            Card card;

            try {
                card = new Card(cardArgs[0], cardArgs[1]);
            } catch (Exception ex) {
                System.out.println("No such card exists.");
                continue;
            }

            if (!deck.contains(card)) {
                System.out.println("Card is not in the deck.");
                continue;
            }

            if (first.isHandEmpty()) {
                first.addCard(card);
            } else if (second.isHandEmpty()) {
                second.addCard(card);
            }

            deck.remove(card);
        }
    }

    private static String getWinner(Player first, Player second) {
        if (first.getMaxCard().compareTo(second.getMaxCard()) >= 0) {
            return String.format("%s wins with %s", first.getName(), first.getMaxCard());
        }

        return String.format("%s wins with %s", second.getName(), second.getMaxCard());
    }
}
