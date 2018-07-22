package customEnumAnnotation;

@MyAnnotation(category = "Suit", description = "Provides suit constants for a Card class.", type = "Enumeration")
public enum CardSuit {
    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    private int power;

    CardSuit(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return String.format("Ordinal value: %d; Name value: %s", this.ordinal(), this.name());
    }
}
