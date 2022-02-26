import java.util.*;
import javax.swing.JOptionPane;

public class Card {
    /**************************************************************************************************************************************************************************************
     * The Card class sets the values for the cards to specific suits within the
     * deck. The class also allows for the retrieval of a card suit and the value
     * of a card.
     * 
     * @author Noah Arden
     * @author Owen Carroll
     * @author Kyle Taylor
     * @version 2/28/2022
     */

    /**************************************************************************************************************************************************************************************
     * Instance Variables
     */
    private int value; // 1 = ace, 2 = 2, 11 = jack. you get it
    private String suit;

    /**************************************************************************************************************************************************************************************
     * Default constructor of the Card class.
     */
    public Card() {
        this.value = 1;
        this.suit = "spades";
    }

    /**************************************************************************************************************************************************************************************
     * The Card(int val, String suit) constructor sets the value of a card and the
     * suit of a card. If the suit or value passed are not an acceptable parameter
     * value, an IllegalArgumentException is thrown.
     * 
     * @param val  - The int val parameter determines the card value.
     * @param suit - The String suit parameter determines the suit of a card.
     * 
     * @throws IllegalArgumentException - The IllegalArgument Exception is thrown
     *                                  when an invalid input is given.
     */
    public Card(int val, String suit) throws IllegalArgumentException {
        IllegalArgumentException e = new IllegalArgumentException(); // thrown if invalid input

        // List of allowed card suits
        ArrayList<String> suits = new ArrayList<String>();
        suits.add("hearts");
        suits.add("diamonds");
        suits.add("spades");
        suits.add("clubs");

        // try {
        if (val > 0 && val < 14)
            this.value = val;
        else {
            throw e;
        }
        if (suits.contains(suit))
            this.suit = suit;
        else {
            throw e;
        }
        // } catch (IllegalArgumentException ill) {
        // JOptionPane.showMessageDialog(null, "ERROR: invalid input", "ERROR",
        // JOptionPane.ERROR_MESSAGE);
        // }
    }

    /**************************************************************************************************************************************************************************************
     * The getSuit() method retrieves the suit of a card.
     * 
     * @return String - Returns the suit of the card
     */
    public String getSuit() {
        return this.suit;
    }

    /**************************************************************************************************************************************************************************************
     * The getValue() method retrieves the value of a card.
     * 
     * @return int - Returns the value of the card
     */
    public int getValue() {
        return this.value;
    }
}