package cardGame;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public boolean isHandEmpty() {
        return this.hand.size() < 5;
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public Card getMaxCard() {
        return this.hand.stream().sorted(Comparator.reverseOrder()).findFirst().get();
    }

    public String getName() {
        return name;
    }
}
