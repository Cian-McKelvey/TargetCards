import java.util.Random;
import java.util.Scanner;

public class TargetCard {

    public final static int TARGETVALUE = 51;

    public static void main(String[] args) {
        // Creating the deck of cards and scanner object
        Card[] deck = Card.makeDeck();
        Queue<Card> cardQueue = new Queue<Card>();
        Scanner input = new Scanner(System.in);

        // Score tracker variables
        int totalScore = 0;
        int totalScore2 = 0;

        System.out.println("\nHello and welcome to Target Cards!!!\n");

        // Main game loop
        int gameCount = 1;
        while (gameCount <= 4) {
            // Shuffling the deck
            shuffleDeck(deck);
            // Creating a queue and adding the shuffled array of cards to it
            for (Card card : deck)
                cardQueue.enqueue(card);


            // Starting the game from user perspective as player1
            System.out.println("\n----------------------------");
            System.out.println("Round " + gameCount);
            System.out.println("----------------------------");

            // Creating hand for player 1 and 2 of appropriate amount
            System.out.println("PLAYER 1");
            System.out.println("----------------------------");
            Card[] handDealt = createHand(input, cardQueue);
            System.out.println("PLAYER 2");
            System.out.println("----------------------------");
            Card[] handDealt2 = createHand(input, cardQueue);


            // Printing player1's hand and adding the scores together
            System.out.println("\nPlayer1's Hand: \n");
            Card.printDeck(handDealt);
            int sumHand = sumOfHand(handDealt);


            // Calculating this rounds score and updating the total score variable
            System.out.println("\nHand value (PLAYER 1) = " + sumHand);
            totalScore = totalScore + scoreCalculator(sumHand);
            System.out.println("Total Score (PLAYER 1) = " + totalScore);



            // Printing player2's hand and adding the scores together
            System.out.println("\nPlayer2's Hand: \n");
            Card.printDeck(handDealt2);
            int sumHand2 = sumOfHand(handDealt2);

            // Calculating this rounds score and updating the total score variable
            System.out.println("\nHand value (PLAYER 2) = " + sumHand2);
            totalScore2 = totalScore2 + scoreCalculator(sumHand2);
            System.out.println("Total Score (PLAYER 2) = " + totalScore2);



            // Resetting the array and queue for the next round
            reset(handDealt, handDealt2, cardQueue);
            // Incrementing the game counter
            gameCount++;

        } // End of Game loop

        // Closing the scanner
        input.close();
        // Displaying ending message
        gameOverMessage(totalScore, totalScore2);
    }



    // Using algorithm to shuffle deck array
    public static void shuffleDeck(Card[] cards) {

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


    /* Finding the sum of the ranks of each card in the hand

    if rank = 1 it's an ace so add 11
    if rank = 2 through 10 its the right amount so just add the amount received from getRank()
    if rank = 11 through 13 it's either jack queen or king so return 10

    */
    public static int sumOfHand(Card[] arr) {
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


    // Dealing the correct amount od cards from the stack as a hand
    public static Card[] createHand(Scanner scan, Queue<Card> cardQueue) {
        // Getting input on how many cards should be dealt
        System.out.println("How many cards would you like?");
        int numCardsDealt = scan.nextInt();
        System.out.println("\nDealing " + numCardsDealt + " cards!\n");

        // Creating a hand of cards
        Card[] handDealt = new Card[numCardsDealt];
        // Removing cards from the queue and adding to the hand
        for (int i = 0; i < handDealt.length; i++) {
            handDealt[i] = cardQueue.dequeue();
        }
        return handDealt;
    }


    // Only here to check how much the player is over by, not used in calculating score
    public static int over(int rankValue, int max) {
        return (rankValue - max);
    }


    // Used to check how much they are under by, used in counting score
    public static int under(int rankValue, int max) {
        return (max - rankValue);
    }


    // Finds the round score needed to be added to the total score
    // Takes into consideration if they were over or under the target value
    public static int scoreCalculator(int sumOfHand) {
        int roundScore = 0;

        // If score is greater than the target value, add the target value to their score
        if (sumOfHand > TARGETVALUE) {
            // Method is still there to calculate how much they were over by, it just isn't used in the score tally
            int overBY = over(sumOfHand, TARGETVALUE);
            // Displaying this result in output
            System.out.println("They were over by: " + overBY);
            // The target value is used here and not how much they were over by
            roundScore = roundScore + TARGETVALUE;
        }
        // If the score is less than the target value, add the amount they were off by to their score
        else if (sumOfHand < TARGETVALUE){
            // Uses the under method to calculate how much they were under by
            int underBy = under(sumOfHand, TARGETVALUE);
            // Displaying this result in output
            System.out.println("They were under by: " + underBy);
            // Returning how much they were over by
            roundScore = roundScore + underBy;
        }
        else {
            // Letting the user know they hit the target value, doesn't add to their score
            System.out.println("You got a sum of 51!!! Well done!!!");
            roundScore = roundScore + 0;
        }

        return roundScore;
    }


    // Resetting the arrays and queues
    public static void reset( Card[] dealtHand, Card[] dealtHand2, Queue<Card> queue) {
        dealtHand = null;
        dealtHand2 = null;
        queue.clear();
    }


    // Displaying ending message
    public static void gameOverMessage(int score1, int score2) {
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