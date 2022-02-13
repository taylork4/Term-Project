import java.util.*;
import javax.swing.JOptionPane;

public class Card {
    private int value;   //1 = ace, 2 = 2, 11 = jack. you get it
    private String suit;
    
    
    
    public Card(){
        this.value = 1;
        this.suit = "spades";
    }

    public Card(int val, String suit) throws IllegalArgumentException{
        IllegalArgumentException e = new IllegalArgumentException();    // thrown if invalid input

        //list of allowed card suits
        ArrayList<String> suits = new ArrayList<String>();
        suits.add("hearts");
        suits.add("diamonds");
        suits.add("spades");
        suits.add("clubs");

        //try {
            if(val > 0 && val < 14)
                this.value = val;
            else {
                throw e;
            }
            if(suits.contains(suit))
                this.suit = suit;
            else {
                throw e;
            }
        //} catch (IllegalArgumentException ill) {
          //  JOptionPane.showMessageDialog(null, "ERROR: invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
        //}
    }

    /**
     * getter for suit
     * @return returns the suit of the card
     */
    public String getSuit(){
        return this.suit;
    }

    /**
     * getter for value
     * @return returns the value of the card
     */
    public int getValue(){
        return this.value;
    }
}