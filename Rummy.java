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

    /**
     * when a player plays a meld, this method is called, and it is added to the
    // list of melds.
     * @param d deck to be added to list of melds
     */
    public void addMeld(Deck d){
        this.melds.add(d);
    }

    /**
     * method to deal cards to each player
     * TODO: - make it so that number of players cant be < 2
     */
    public void deal(){
        for(int h = 0; h < 7; h++){
            for(int i = 0; i < this.players.size(); i++){
                Deck.move(this.deck, this.players.get(i).hand, this.deck.cardArr.get(0)); // moving cards from the deck to
            }                                                                               // the player's hands
        }                                                        
    }

    /**
     * method to draw a card from either the discard pile or the regular deck
     * @param from the deck the card comes from
     * @param to the deck the card is moving to
     */
    public void draw(Deck from, Deck to ){
        if(from.equals(this.deck) || from.equals(this.discard)){    // can only draw from discard pile or deck
            Deck.move(from, to, from.cardArr.get(from.cardArr.size() - 1));
            //move the card from bottom of whichever deck to player's deck
        }
    } 

    /**
     * moves a card from the player's deck to the discard pile
     * @param p player who is discarding
     * @param c card being discarded
     */
    public void discard(Player p, Card c){
        Deck.move(p.hand, this.discard, c);
    }
    
    /**
     * checks if a deck is a meld. returns 1 if it is a meld, 0 if not a meld.
     * NOTE: MELDS MUST BE IN ORDER FROM LOWEST CARD VALUE TO HIGHEST CARD VALUE
     * @param d deck you are checking if is meld
     */
    public static int checkMeld(Deck d){
        if(d.cardArr.size() >= 3){ // meld must have at least 3 cards
            if(!(d.cardArr.get(0).getSuit().equals(d.cardArr.get(1).getSuit()))) {  // if card 1 and 2 are different suit
                for(int i = 0; i < d.cardArr.size() - 1; i++){
                    if(d.cardArr.get(i).getValue() == d.cardArr.get(i + 1).getValue()) { // make sure cards are same value
                        continue;
                    } else {
                        return 0;
                    }
                    
                }
                return 1;
            } else if(d.cardArr.get(0).getSuit().equals(d.cardArr.get(1).getSuit())) {  // if card 1 and 2 are same suit
                for(int i = 0; i < d.cardArr.size() - 1; i++){
                    if(d.cardArr.get(i).getSuit().equals(d.cardArr.get(i + 1).getSuit())
                    && d.cardArr.get(i).getValue() == d.cardArr.get(i + 1).getValue() - 1){
                        continue;
                    } else {
                        return 0;
                    }
                }
                return 1;
            }
        } 
        
        return 0;
        
    }

    /**
     * method to add players to player array
     * @param players number of players to be added
     */
    public void addPlayer(int players){
        for(int i = 0; i < players; i++){
            this.players.add(new Player());
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