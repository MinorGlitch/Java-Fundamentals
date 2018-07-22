package cardsWithPower;

public class Card {
    private CardSuit suit;
    private CardRank rank;

    public Card(String rank, String suit) {
        this.rank = Enum.valueOf(CardRank.class, rank.toUpperCase());
        this.suit = Enum.valueOf(CardSuit.class, suit.toUpperCase());
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.rank.name(), this.suit.name(), this.calculateCardPower());
    }

    private int calculateCardPower() {
        return this.suit.getPower() + this.rank.getPower();
    }
}
