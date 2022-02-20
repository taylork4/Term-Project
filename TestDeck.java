import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class TestDeck {
    Deck full = new Deck();
    Deck empty = new Deck(0);

    @Test
    public void testFullDeckConstructor(){
        for(int i = 0; i < 52; i++){
            switch(i % 4){
                case 0:
                    assertEquals(full.cardArr.get(i).getSuit(), "spades"); 
                    break;
                case 1:
                    assertEquals(full.cardArr.get(i).getSuit(), "clubs");
                    break;
                case 2:
                    assertEquals(full.cardArr.get(i).getSuit(), "hearts");
                    break;
                case 3:
                    assertEquals(full.cardArr.get(i).getSuit(), "diamonds");
                    break;


            }
            assertEquals(full.cardArr.get(i).getValue(), (i/4) + 1);
        }
    }

    @Test
    public void testEmpty(){
        assertEquals(empty.cardArr.size(), 0);  // really complex method. change at your own risk
    }

    @Test
    public void testAdd(){
        Deck d = new Deck(0);
        d.add(new Card(3, "hearts"));

        assertEquals(d.cardArr.get(0).getSuit(), "hearts");
        assertEquals(d.cardArr.get(0).getValue(), 3);

       
    }

    @Test
    public void testRemove(){
        Deck d = new Deck(0);
        Card c = new Card(1, "hearts");

        d.add(c);
        assertTrue(d.cardArr.contains(c));
        assertTrue(d.cardArr.size() == 1);        
        d.remove(c);
        assertTrue(d.cardArr.size() == 0);

        assertFalse(d.cardArr.contains(c));

        d.add(new Card(1, "spades"));

        assertEquals(d.cardArr.size(), 1);
    }

    @Test
    public void testMove(){
        Deck d1 = new Deck(0);
        Deck d2 = new Deck(0);
        Card c = new Card(1, "spades");

        d1.add(c);

        Deck.move(d1, d2, c);

        assertEquals(d2.cardArr.get(0).getSuit(), "spades");
        System.out.println(d1.cardArr.size());
        assertEquals(d1.cardArr.size(), 0);
    }

    @Test
    public void testShuffle(){
        Deck d = new Deck();

        d.shuffle();
        assertEquals(d.cardArr.size(), 52);

        if(d.cardArr.get(0).getSuit().equals("spades") && d.cardArr.get(0).getValue() == 1){
            assertFalse(d.cardArr.get(1).getSuit().equals("clubs") && d.cardArr.get(1).getValue() == 1);
        }   // Ok, there is a 1 in 2704 chance that this gives a false test failure, but come on.

    }
}
