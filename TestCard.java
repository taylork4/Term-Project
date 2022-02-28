import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class TestCard {
    /**************************************************************************************************************************************************************************************
     * The TestCard class tests the methods within the Card class.
     * 
     * @author Noah Arden
     * @author Owen Carroll
     * @author Kyle Taylor
     * @version 2/28/2022
     */

    /**************************************************************************************************************************************************************************************
     * Instance Variables
     */
    Card c = new Card();
    Card cParam = new Card(5, "clubs");

    /**************************************************************************************************************************************************************************************
     * The testGet() method tests whether the getSuit() method retrieves the cards
     * suit properly and if the getValue() method retrieves the cards value properly
     * from within the default constructor.
     */
    @Test
    public void testGet() {
        assertEquals(c.getSuit(), "spades");
        assertEquals(c.getValue(), 1);
    }

    /**************************************************************************************************************************************************************************************
     * The testConstructorParam() method tests whether the getSuit() method
     * retrieves the cards suit properly and if the getValue() method retrieves
     * the cards value properly from within the (int, String) constructor
     */
    @Test
    public void testConstructorParam() {
        assertEquals(cParam.getSuit(), "clubs");
        assertEquals(cParam.getValue(), 5);
    }

    /**************************************************************************************************************************************************************************************
     * The testBadParam() method tests whether setting a parameter value
     * for the card suit or value is correct or not.
     */
    @Test
    public void testBadParam() {
        assertThrows(IllegalArgumentException.class, () -> {
            Card cBadParam = new Card(1, "apples");
            Card cBadParam2 = new Card(-1, "spades");
            Card cBadParam3 = new Card(0, "clubs");
            Card cBadParam4 = new Card(54, "spades"); 
        });
    }
}
