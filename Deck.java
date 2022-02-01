import java.util.*;

public class Deck {
    public ArrayList<Card> cardArr = new ArrayList<Card>();

    //constructor for an empty deck: pass in any integer parameter
    public Deck(int zero){}

    //constructor for a full deck
    public Deck(){
        int value = 1;
        switch(value) {
            case 1: this.cardArr.add(new Card(1, "spades"));
                    this.cardArr.add(new Card(1, "clubs"));
                    this.cardArr.add(new Card(1, "hearts"));
                    this.cardArr.add(new Card(1, "diamonds"));
            
            case 2: this.cardArr.add(new Card(2, "spades"));
                    this.cardArr.add(new Card(2, "clubs"));
                    this.cardArr.add(new Card(2, "hearts"));
                    this.cardArr.add(new Card(2, "diamonds"));

            case 3: this.cardArr.add(new Card(3, "spades"));
                    this.cardArr.add(new Card(3, "clubs"));
                    this.cardArr.add(new Card(3, "hearts"));
                    this.cardArr.add(new Card(3, "diamonds"));

            case 4: this.cardArr.add(new Card(4, "spades"));
                    this.cardArr.add(new Card(4, "clubs"));
                    this.cardArr.add(new Card(4, "hearts"));
                    this.cardArr.add(new Card(4, "diamonds"));

            case 5: this.cardArr.add(new Card(5, "spades"));
                    this.cardArr.add(new Card(5, "clubs"));
                    this.cardArr.add(new Card(5, "hearts"));
                    this.cardArr.add(new Card(5, "diamonds"));

            case 6: this.cardArr.add(new Card(6, "spades"));
                    this.cardArr.add(new Card(6, "clubs"));
                    this.cardArr.add(new Card(6, "hearts"));
                    this.cardArr.add(new Card(6, "diamonds"));

            case 7: this.cardArr.add(new Card(7, "spades"));
                    this.cardArr.add(new Card(7, "clubs"));
                    this.cardArr.add(new Card(7, "hearts"));
                    this.cardArr.add(new Card(7, "diamonds"));

            case 8: this.cardArr.add(new Card(8, "spades"));
                    this.cardArr.add(new Card(8, "clubs"));
                    this.cardArr.add(new Card(8, "hearts"));
                    this.cardArr.add(new Card(8, "diamonds"));

            case 9: this.cardArr.add(new Card(9, "spades"));
                    this.cardArr.add(new Card(9, "clubs"));
                    this.cardArr.add(new Card(9, "hearts"));
                    this.cardArr.add(new Card(9, "diamonds"));

            case 10: this.cardArr.add(new Card(10, "spades"));
                    this.cardArr.add(new Card(10, "clubs"));
                    this.cardArr.add(new Card(10, "hearts"));
                    this.cardArr.add(new Card(10, "diamonds"));

            case 11: this.cardArr.add(new Card(11, "spades"));
                    this.cardArr.add(new Card(11, "clubs"));
                    this.cardArr.add(new Card(11, "hearts"));
                    this.cardArr.add(new Card(11, "diamonds"));

            case 12: this.cardArr.add(new Card(12, "spades"));
                    this.cardArr.add(new Card(12, "clubs"));
                    this.cardArr.add(new Card(12, "hearts"));
                    this.cardArr.add(new Card(12, "diamonds"));

            case 13: this.cardArr.add(new Card(13, "spades"));
                    this.cardArr.add(new Card(13, "clubs"));
                    this.cardArr.add(new Card(13, "hearts"));
                    this.cardArr.add(new Card(13, "diamonds"));
                  
        }

    }

    //method to add a card to a deck
    public void add(Card c){
        if(!this.cardArr.contains(c))
            this.cardArr.add(c);
    }

    //method to remove a card from a deck
    public void remove(Card c){
        this.cardArr.remove(c);
    }

    //method to move a card from one deck to another
    public static void move(Deck d1, Deck d2, Card c){
        d2.add(c);
        d1.remove(c);
    }

    public void shuffle(){
        for(int i = 0; i < this.cardArr.size(); i++){
            int num = i;
            Card placeholder;
            
            num = (int) Math.random() * this.cardArr.size();    //random card index
            placeholder = this.cardArr.get(i);  
            this.cardArr.add(i, this.cardArr.get(num));     //replace card at i with card at random index
            this.cardArr.add(num, placeholder); // replace card at random value with card at i
        }
    }
}
