public class Player {
    /**************************************************************************************************************************************************************************************
     * 
     * The Player class sets the score and creates a hand where the players cards
     * will go into at the start
     * of the game.
     * 
     * @author Noah Arden
     * @author Owen Carroll
     * @author Kyle Taylor
     * @version 2/28/2022
     * 
     */

    /**************************************************************************************************************************************************************************************
     * 
     * Instance Variables
     * 
     */
    private int score;
    private Deck hand;

    /**************************************************************************************************************************************************************************************
     * 
     * Default constructor of the Card class.
     * 
     */
    public Player() {
        score = 0; // Player starts with empty deck and no score.
        hand = new Deck(0); // Cards will be dealt at the start of the game (from Rummy class)
    }

    /**************************************************************************************************************************************************************************************
     * 
     * The addPoint() method awards points to the player.
     * 
     */
    public void addPoint() {
        this.score++;
    }

}
