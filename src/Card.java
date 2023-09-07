public class Card {

    public static final String[] RANKS = {null,"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
    public static final String[] SUITS = {"Clubs","Diamonds","Hearts","Spades"};

    private final int suit;
    private final int rank;

    // Overloaded constructor only as the deck of cards is created through a method
    public Card(int rank, int suit) {
        this.suit = suit;
        this.rank = rank;
    }

    // Getters for both rank and suit
    public int getRank() {
        return this.rank;
    }

    public int getSuit() {
        return this.suit;
    }

    // Creates a 52 card deck of every possible card from the ranks and suits
    public static Card[] makeDeck() {
        Card[] cards = new Card[52];
        int index = 0;

        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                cards[index] = new Card(rank, suit);
                index++;
            }
        }

        return cards;
    }

    @Override
    public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suit];
    }

    // Prints the deck of cards
    public static void printDeck(Card[] deck) {
        for (Card card : deck)
            System.out.println(card);
    }
}