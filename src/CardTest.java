import java.util.Random;

public class CardTest {
    public static void main(String[] args) {
        // Test card created
        Card testCard = new Card(6,3);
        System.out.println(testCard);
        System.out.println("Rank: " + testCard.getRank());
        System.out.println("Suit: " + testCard.getSuit());

        System.out.println("\nCard Deck:");
        Card[] cardDeckTest = Card.makeDeck();
        for (Card card : cardDeckTest)
            System.out.print(card + ", ");

        System.out.println("\nShuffled Card Deck:");
        shuffleDeckTest(cardDeckTest);
        for (Card card : cardDeckTest)
            System.out.print(card + ", ");

    }

    // Testing implementation of array shuffler
    public static void shuffleDeckTest(Card[] cards) {

        Random rand = new Random();
        Card temp;

        int index;
        for (int i = cards.length - 1; i > 0; i--) {
            index = rand.nextInt(i + 1);
            temp = cards[index];
            cards[index] = cards[i];
            cards[i] = temp;
        }
    }
}