import java.util.*;
//https://github.com/nivedk/Rummy/blob/master/Game.java
//Reference for general structure ^^
public class Rummy {
    /**************************************************************************************************************************************************************************************
 	 * 
	 * The Rummy class controls the main operations of the game. The class is responsible for initializing the card deck, discard pile, and
     * determining if the game should continue or end. It is also able to take a number of cards and shuffle them.
	 * 
     * @author Noah Arden
     * @author Owen Carroll
	 * @author Kyle Taylor
     * @version 1/30/2022
 	 * 
 	 */

    /**************************************************************************************************************************************************************************************
     * 
     * Instance Variables
     * 
     */

    private int[] deck;
    private int[] discard;
    private boolean gameInProg;
    private boolean setupComplete;
    //private Player player;

    /**************************************************************************************************************************************************************************************
 	 * 
	 * Default constructor of the Rummy class.
     * 
 	 */

    public Rummy() {
        deck = new int[52];
        discard = new int[52];
        gameInProg = true;
        setupComplete = false;
    }

    /**************************************************************************************************************************************************************************************
 	 * 
	 * The play() method essentially starts the game. It shuffles the card deck and handles game operations.
     * 
 	 */

    public void play() {
        for (int i = 0; i < 52; i++) {
            deck[i] = i;
        }
        deck = shuffle(deck, 52);
        System.out.println("--------------");
        // for (int i = 0; i < 52; i++) {           //Simply used to show the cards are shuffled properly
        //     System.out.print(deck[i]+ ", ");
        //     if (i % 10 == 0 && i != 0) {
        //         System.out.println();
        //     }
        // }
        //System.out.println("Shuffled = " + deck[0]);
    }
    
    /**************************************************************************************************************************************************************************************
 	 * 
	 * The shuffle(int[], int) method shuffles the values in an integer array (Card shuffler).  
     * @param cards = Integer array that holds a number of cards being sent to the method to be shuffled.
     * @param num = Integer value representing the number of cards being sent to the method to be shuffled.
     * 
 	 */
    public static int[] shuffle(int[] cards, int num) {
        Random rand = new Random();
        for (int i = 0; i < num; i++) {
			int randNum = rand.nextInt(num);
			int temp = cards[randNum];
			cards[randNum] = cards[i];
			cards[i] = temp;
		}
        return cards;
    }

    /**************************************************************************************************************************************************************************************
 	 * 
	 * The main method for Rummy.
     * @param args = An array of String arguments that allow main() to operate.
     * 
 	 */
    public static void main(String[] args) {
        Rummy rummy = new Rummy();
        rummy.play();
    }
}