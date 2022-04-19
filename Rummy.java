import java.util.ArrayList;

//https://github.com/nivedk/Rummy/blob/master/Game.java
//Reference for general structure ^^
public class Rummy {
    /**************************************************************************************************************************************************************************************
     * The Rummy class controls the main operations of the game. The class is
     * responsible for initializing the card deck, discard pile, and
     * determining if the game should continue or end. It is also able to take a
     * number of cards and shuffle them.
     * 
     * @author Noah Arden
     * @author Owen Carroll
     * @author Kyle Taylor
     * @version 2/28/2022
     */

    /**************************************************************************************************************************************************************************************
     * Instance Variables
     */
    public Deck deck; // the full game deck
    private Deck discard; // an empty deck (discard pile)
    private Deck maybeMeld; // stores cards that may be a meld when the player attempts to make 
                            // a meld
    private boolean gameInProg;
    private boolean setupComplete;
    private ArrayList<Deck> melds;
    private ArrayList<Player> players;
    // private Player player;

    /**************************************************************************************************************************************************************************************
     * Default constructor of the Rummy class.
     */
    public Rummy() {
        deck = new Deck();
        discard = new Deck(0);
        melds = new ArrayList<Deck>();
        players = new ArrayList<Player>();
        gameInProg = true;
        setupComplete = false;
    }

    /**************************************************************************************************************************************************************************************
     * The play() method starts the game. It shuffles the card deck and handles game
     * operations.
     */
    public void play() {
        deck.shuffle();
        System.out.println("--------------");
        /*
         * for (int i = 0; i < 52; i++) { //Simply used to show the cards are shuffled
         * properly
         * System.out.print(deck[i]+ ", ");
         * if (i % 10 == 0 && i != 0) {
         * System.out.println();
         * }
         * }
         * System.out.println("Shuffled = " + deck[0]);
         */
    }

    /**************************************************************************************************************************************************************************************
     * The addMeld(Deck d) method is called when a player plays a meld, adding the
     * players deck to a list of melds.
     * 
     * @param d - Deck to be added to list of melds
     */
    public void addMeld(Deck d) {
        this.melds.add(d);
    }

    /**************************************************************************************************************************************************************************************
     * The deal() method deals cards to each player.
     * TODO: - make it so that number of players cannot be < 2
     */
    public void deal() {
        for (int h = 0; h < 7; h++) {
            for (int i = 0; i < this.players.size(); i++) {
                Deck.move(this.deck, this.players.get(i).hand, this.deck.cardArr.get(0)); // moving cards from the deck
                                                                                          // to the player's hands
            }
        }
    }

    /**************************************************************************************************************************************************************************************
     * The draw(Deck from, Deck to) method draws a card from either the discard pile
     * or the regular deck.
     * 
     * @param from - Deck the card comes from
     * @param to   - Deck the card is moving to
     */
    public void draw(Deck from, Deck to) {
        if (from.equals(this.deck) || from.equals(this.discard)) { // can only draw from discard pile or deck
            Deck.move(from, to, from.cardArr.get(from.cardArr.size() - 1)); // move the card from bottom of whichever
                                                                            // deck to player's deck
        }
    }

    /**************************************************************************************************************************************************************************************
     * The discard(Player p, Card c) method moves a card from the player's Deck to
     * the discard pile.
     * 
     * @param p - Player who is discarding
     * @param c - Card being discarded
     */
    public void discard(Player p, Card c) {
        Deck.move(p.hand, this.discard, c);
    }

    /**
     * getter for discard pile
     * @return the discard pile
     */
    public Deck getDiscard() {
        return this.discard;
    }

    /**************************************************************************************************************************************************************************************
     * The checkMeld(Deck d) method checks if a Deck is a meld.
     * NOTE: MELDS MUST BE IN ORDER FROM LOWEST CARD VALUE TO HIGHEST CARD VALUE
     * 
     * @param d - Deck that is being checked for whether it is is a meld
     * @return int - Returns an integer 1 if it is a meld, 0 if not a meld.
     */
    public static int checkMeld(Deck d) {
        if (d.cardArr.size() >= 3) { // meld must have at least 3 cards
            if (!(d.cardArr.get(0).getSuit().equals(d.cardArr.get(1).getSuit()))) { // Card 1 and 2 are different suit
                for (int i = 0; i < d.cardArr.size() - 1; i++) {
                    if (d.cardArr.get(i).getValue() == d.cardArr.get(i + 1).getValue()) { // Cards are same value
                        continue;
                    } else {
                        return 0;
                    }

                }
                return 1;
            } else if (d.cardArr.get(0).getSuit().equals(d.cardArr.get(1).getSuit())) { // Card 1 and 2 are same suit
                for (int i = 0; i < d.cardArr.size() - 1; i++) {
                    if (d.cardArr.get(i).getSuit().equals(d.cardArr.get(i + 1).getSuit())
                            && d.cardArr.get(i).getValue() == d.cardArr.get(i + 1).getValue() - 1) {
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

    /**************************************************************************************************************************************************************************************
     * The addPlayers(int players) method adds players to player array
     * 
     * @param players - Integer number of players to be added
     */
    public void addPlayer(int players) {
        for (int i = 0; i < players; i++) {
            this.players.add(new Player());
        }
    }

    /**
     * getter for array of players
     * 
     * @param playerNum number of player to be returned
     * @return player at passed in index
     */
    public Player getPlayer(int playerNum) {
        return players.get(playerNum);
    }

    /**
     * 
     * @param index index of the card to be returned
     * @return the card at the passed in index
     */
    public Card getCard(int index) {
        return this.deck.cardArr.get(index);
    }

    /**
     * getter for maybeMeld
     * @return deck that player is trying to make a meld with
     */
    public Deck getMaybeMeld() {
        return maybeMeld;
    }

    /**
     * setter for maybeMeld
     * @param maybeMeld deck that player is trying to make a meld with
     * @return returns 1 if maybeMeld is a meld, 0 if not
     */
    public int setMaybeMeld(Deck maybeMeld, Player p) {
        this.maybeMeld = maybeMeld;
        if(checkMeld(this.maybeMeld) == 1){
            this.addMeld(this.maybeMeld);
            
            //loop: to remove cards in the meld from the player's hand
            for(Card meldCard : this.maybeMeld.cardArr) {
                for(int i = 0; i < p.hand.cardArr.size(); i++) {
                    if(p.hand.cardArr.get(i) == meldCard)
                        p.hand.cardArr.remove(i);
                }
            }

            return 1;
        } else {
            return 0;
        }
    }

    /**************************************************************************************************************************************************************************************
     * The main method for Rummy.
     * 
     * @param args - An array of String arguments that allow main() to operate.
     */
    public static void main(String[] args) {
        Rummy rummy = new Rummy();
        rummy.play();
    }
}