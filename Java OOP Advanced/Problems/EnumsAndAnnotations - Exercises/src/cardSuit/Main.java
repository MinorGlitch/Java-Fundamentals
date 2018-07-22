package cardSuit;

public class Main {
    public static void main(String[] args) {
        CardSuits[] cardSuits = CardSuits.class.getEnumConstants();

        System.out.println("Card Suits:");
        for (CardSuits cardSuit : cardSuits) {
            System.out.println(cardSuit);
        }
    }
}
