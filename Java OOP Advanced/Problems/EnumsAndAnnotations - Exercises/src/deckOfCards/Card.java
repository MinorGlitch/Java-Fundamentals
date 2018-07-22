package deckOfCards;

public class Card {
    private CardSuit suit;
    private CardRank rank;

    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return String.format("%s of %s",
                this.rank.name(), this.suit.name());
    }
}
