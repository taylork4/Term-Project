import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class TestPlayer {
    /**************************************************************************************************************************************************************************************
     * The TestDeck class tests the methods within the Deck class.
     * 
     * @author Noah Arden
     * @author Owen Carroll
     * @author Kyle Taylor
     * @version 4/21/2022
     */

    /**************************************************************************************************************************************************************************************
     * Instance Variables
     */
    Player george = new Player();

    /**************************************************************************************************************************************************************************************
     * The testAddNumMelds() method tests whether number of melds are incremented
     * correctly.
     */
    @Test
    public void testAddNumMelds() {
        assertEquals(george.getNumMelds(), 0);
        george.addNumMelds();
        assertEquals(george.getNumMelds(), 1);
    }

    /**************************************************************************************************************************************************************************************
     * The testAddPoints() method tests whether points are incremented correctly.
     */
    @Test
    public void testAddPoints() {
        george.addPoints(7);
        assertEquals(george.getScore(), 7);
        george.addPoints(5);
        assertEquals(george.getScore(), 12);
        george.addPoints(-5);
        assertEquals(george.getScore(), 12);
    }

    /**************************************************************************************************************************************************************************************
     * The testSubPoints() method tests whether points are decremented correctly.
     */
    @Test
    public void testSubPoints() {
        george.subPoints(7);
        assertEquals(george.getScore(), 0);
        george.subPoints(-7);
        assertEquals(george.getScore(), 0);
        george.addPoints(5);
        george.subPoints(3);
        assertEquals(george.getScore(), 2);
        george.subPoints(-1);
        assertEquals(george.getScore(), 1);
    }

    /**************************************************************************************************************************************************************************************
     * The testGetANDSetScore() method tests whether the score can be retrieved and
     * set.
     */
    @Test
    public void testGetANDSetScore() {
        assertEquals(george.getScore(), 0);
        george.setScore(5);
        assertEquals(george.getScore(), 5);
        george.setScore(-5);
        assertEquals(george.getScore(), 0);
    }
}
