import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class TestRummy {
    /**************************************************************************************************************************************************************************************
     * The TestRummy class tests the methods within the Rummy class.
     * 
     * @author Noah Arden
     * @author Owen Carroll
     * @author Kyle Taylor
     * @version 2/28/2022
     */

    /**************************************************************************************************************************************************************************************
     * Instance Variables
     */
    Rummy rummy = new Rummy();

    /**************************************************************************************************************************************************************************************
     * The testCheckMeld() method tests whether or not a player has a meld
     * and that the full deck should not have a meld.
     */
    @Test
    public void testCheckMeld() {
        Deck d = new Deck();
        Deck e = new Deck(0);
        Deck f = new Deck(0);

        assertEquals(0, Rummy.checkMeld(d)); // full deck d should not be a meld.

        for (int i = 1; i <= 5; i++) {
            Card c = new Card(i, "spades");
            e.add(c);
        }

        assertEquals(1, Rummy.checkMeld(e)); // ace of spades, 2 of spades, 3 of spades, etc is a meld.

        Card card1 = new Card(10, "spades");
        Card card2 = new Card(10, "clubs");
        Card card3 = new Card(10, "hearts");
        Card card4 = new Card(10, "diamonds");

        f.add(card1);
        f.add(card2);
        f.add(card3);
        f.add(card4);

        assertEquals(1, Rummy.checkMeld(f)); // same value, different suits is meld.
    }
}
