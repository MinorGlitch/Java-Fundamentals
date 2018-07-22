package cardGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Deck implements Iterable<Card> {
    private List<Card> cards;

    public Deck() {
        this.cards = this.createDeck();
    }

    private List<Card> createDeck() {
        List<Card> tempCards = new ArrayList<>();

        for (CardSuit cardSuit: CardSuit.values()) {
            for (CardRank cardRank : CardRank.values()) {
                tempCards.add(new Card(cardRank, cardSuit));
            }
        }

        return tempCards;
    }

    public boolean contains(Card card) {
        return this.cards.stream().anyMatch(c -> c.compareTo(card) == 0);
    }

    public void remove(Card card) {
        this.cards.removeIf(c -> c.compareTo(card) == 0);
    }

    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }
}
