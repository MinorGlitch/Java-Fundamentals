package cardGame;

public class Card implements Comparable<Card> {
    private CardSuit suit;
    private CardRank rank;

    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Card(String rank, String suit) {
        this.rank = Enum.valueOf(CardRank.class, rank);
        this.suit = Enum.valueOf(CardSuit.class, suit);
    }

    @Override
    public String toString() {
        return String.format("%s of %s.",
                this.rank.name(), this.suit.name());
    }

    private int calculateCardPower() {
        return this.suit.getPower() + this.rank.getPower();
    }

    @Override
    public int compareTo(Card o) {
        return this.calculateCardPower() - o.calculateCardPower();
    }
}
