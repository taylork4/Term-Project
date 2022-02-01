import java.util.*;


public class Card {
    public int value;   //1 = ace, 2 = 2, 11 = jack. you get it
    public String suit;
    
    
    
    public Card(){
        this.value = 1;
        this.suit = "spades";
    }

    public Card(int val, String suit){

        //list of allowed card suits
        ArrayList<String> suits = new ArrayList<String>();
        suits.add("hearts");
        suits.add("diamonds");
        suits.add("spades");
        suits.add("clubs");

        if(val > 0 && val < 14)
            this.value = val;
        if(suits.contains(suit))
            this.suit = suit;
    }
}