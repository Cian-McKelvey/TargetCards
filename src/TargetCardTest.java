import java.util.Random;

public class TargetCardTest {

    public final static int TARGETVALUETEST = 51;

    public static void main(String[] args) {

        /* Basics Testing

        Card[] deckTest = Card.makeDeck();
        Queue<Card> cardQueueTest = new Queue<Card>();

        shuffleDeckTest(deckTest);

        for (Card card : deckTest)
            cardQueueTest.enqueue(card);

        Card[] testHandDealt = createHandTest(3, cardQueueTest);
        Card.printDeck(testHandDealt);

        int sumOfHandTest = sumOfHandTest(testHandDealt);
        System.out.println("The sum of your hand is: " + sumOfHandTest);
        */



        /* Over and Under method tests
        int overTest = overTest(55, TARGETVALUETEST);
        int underTest = underTest(50, TARGETVALUETEST);

        System.out.println("\n(Should be over by 4)");
        System.out.println("You were over by: " + overTest);

        System.out.println("(Should be under by 1)");
        System.out.println("You were under by: " + underTest);
        */


        int player1Test = 5;
        int player2Test = 6;

        // Player 1 should be the winner
        gameOverMessageTest(player1Test, player2Test);
    }


    public static int sumOfHandTest(Card[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int rank = arr[i].getRank();

            if (rank == 1) {
                sum = sum + 11;
            } else if (rank == 11 || rank == 12 || rank == 13) {
                sum = sum + 10;
            } else {
                sum = sum + rank;
            }
        }
        return sum;
    }

    // Using algorithm to shuffle deck array
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


    public static Card[] createHandTest(int deckSize, Queue<Card> cardQueue) {
        System.out.println("\nDealing " + deckSize + " cards!\n");

        Card[] handDealt = new Card[deckSize];

        for (int i = 0; i < handDealt.length; i++) {
            handDealt[i] = cardQueue.dequeue();
        }
        return handDealt;
    }


    // Only here to check how much the player is over by, not used in calculating score
    public static int overTest(int rankValue, int max) {
        return (rankValue - max);
    }


    // Used to check how much they are under by, used in counting score
    public static int underTest(int rankValue, int max) {
        return (max - rankValue);
    }


    // Displaying ending message
    public static void gameOverMessageTest(int score1, int score2) {
        System.out.println("\n");
        System.out.println("\n----------------------------");
        System.out.println(" Game Over! ");
        System.out.println("----------------------------");
        System.out.println("\n");

        // Comparing each players total scores, and displays the winner along with a winning message
        // If player 1 wins
        if (score1 < score2){
            System.out.println("Player 1 wins with a score of " + score1 + ", Player 2 had a score of " + score2);
            System.out.println("Congratulations Player 1!!!");
        }
        // If player 2 wins
        else if (score1 > score2){
            System.out.println("Player 2 wins with a score of " + score2 + ", Player 1 had a score of " + score1);
            System.out.println("Congratulations Player 2!!!");
        }
        // If it's a tie
        else {
            System.out.println("The game ended in a tie!!!");
        }
    }
}