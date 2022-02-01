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

    private Deck deck;     // the full game deck
    private Deck discard; //an empty deck (discard pile)
    private boolean gameInProg;
    private boolean setupComplete;
    private ArrayList<Deck> melds;
    private ArrayList<Player> players;
    //private Player player;

    /**************************************************************************************************************************************************************************************
 	 * 
	 * Default constructor of the Rummy class.
     * 
 	 */

    public Rummy() {
        deck = new Deck();
        discard = new Deck(0);
        melds = new ArrayList<Deck>();
        gameInProg = true;
        setupComplete = false;
    }

    /**************************************************************************************************************************************************************************************
 	 * 
	 * The play() method essentially starts the game. It shuffles the card deck and handles game operations.
     * 
 	 */

    public void play() {
        deck.shuffle();
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
 	 * METHOD ADAPTED AND MOVED TO DECK CLASS
	 * The shuffle(int[], int) method shuffles the values in an integer array (Card shuffler).  
     * @param cards = Integer array that holds a number of cards being sent to the method to be shuffled.
     * @param num = Integer value representing the number of cards being sent to the method to be shuffled.
     * 
 	 */
    /*public static int[] shuffle(int[] cards, int num) {
        Random rand = new Random();
        for (int i = 0; i < num; i++) {
			int randNum = rand.nextInt(num);
			int temp = cards[randNum];
			cards[randNum] = cards[i];
			cards[i] = temp;
		}
        return cards;
    }*/

    //when a player plays a meld, this method is called, and it is added to the
    // list of melds.
    public void addMeld(Deck d){
        this.melds.add(d);
    }

    /**
     * method to deal cards to each player
     * @param p arraylist of players
     * @param d deck
     * TODO: - make it so that number of players cant be < 2
     */
    public void deal(ArrayList<Player> p, Deck d){
        for(int h = 0; h < 7; h++){
            for(int i = 0; i < p.size(); i++){
                Deck.move(d, p.get(i).hand, d.cardArr.get(0)); // moving cards from the deck to
            }                                                   // the player's hands
        }                                                        
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