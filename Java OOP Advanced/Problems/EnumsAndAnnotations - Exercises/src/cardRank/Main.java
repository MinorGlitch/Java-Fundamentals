package cardRank;

public class Main {
    public static void main(String[] args) {
        CardRanks[] cardRanks = CardRanks.class.getEnumConstants();

        System.out.println("Card Ranks:");
        for (CardRanks cardRank : cardRanks) {
            System.out.println(cardRank);
        }
    }
}
