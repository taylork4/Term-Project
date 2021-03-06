public class Player {
    /**************************************************************************************************************************************************************************************
     * The Player class sets the score and creates a hand where the players cards
     * will go into at the start
     * of the game.
     * 
     * @author Noah Arden
     * @author Owen Carroll
     * @author Kyle Taylor
     * @version 2/28/2022
     */

    /**************************************************************************************************************************************************************************************
     * Instance Variables
     */
    private int score;
    private int numMelds;
    private int numTurns;
    public Deck hand;

    /**************************************************************************************************************************************************************************************
     * Default constructor of the Card class.
     */
    public Player() {
        score = 0; // Player starts with empty deck and no score.
        hand = new Deck(0); // Cards will be dealt at the start of the game (from Rummy class)
        numMelds = 0;
        numTurns = 0;
    }

    /**************************************************************************************************************************************************************************************
     * The addNumMelds() method counts the number of turns a player has had.
     */
    public void addNumTurns() {
        this.numTurns++;
    }

    /**************************************************************************************************************************************************************************************
     * The getNumMelds() method retrieves the number of turns a player has had.
     */
    public int getNumTurns() {
        return this.numTurns;
    }

    /**************************************************************************************************************************************************************************************
     * The addNumMelds() method counts the number of melds a player has made.
     */
    public void addNumMelds() {
        this.numMelds++;
    }

    /**************************************************************************************************************************************************************************************
     * The getNumMelds() method retrieves the number of melds a player has made.
     */
    public int getNumMelds() {
        return this.numMelds;
    }

    /**************************************************************************************************************************************************************************************
     * The addPoint() method awards points to the player.
     */
    public void addPoints(int num) {
        if (num < 0) {
            num = 0;
        }
        this.score = score + num;
    }

    /**************************************************************************************************************************************************************************************
     * The subPoint() method removes points from the player.
     */
    public void subPoints(int num) {
        if (num < 0) {
            num = num * -1;
        }
        this.score = score - num;
        if (this.score < 0) {
            this.score = 0;
        }
    }

    /**************************************************************************************************************************************************************************************
     * The getScore() method retrieves the score of the player.
     */
    public int getScore() {
        return this.score;
    }

    /**************************************************************************************************************************************************************************************
     * The setScore() method sets the score of the player.
     */
    public void setScore(int num) {
        this.score = num;
        if (this.score < 0) {
            this.score = 0;
        }
    }
}
