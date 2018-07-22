package deckOfCards;

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

    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }
}
