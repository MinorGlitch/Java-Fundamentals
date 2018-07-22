package deckOfCards;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();

        for (Card card : deck) {
            System.out.println(card);
        }
    }
}
