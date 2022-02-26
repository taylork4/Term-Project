import java.util.*;

public class Deck {
        /**************************************************************************************************************************************************************************************
         * 
         * The Card class sets the values for the cards to specific suits within the
         * deck. The class also allows for the retrieval
         * of a card suit and the value of a card.
         * 
         * @author Noah Arden
         * @author Owen Carroll
         * @author Kyle Taylor
         * @version 2/28/2022
         * 
         */
        public ArrayList<Card> cardArr = new ArrayList<Card>();

        // constructor for an empty deck: pass in any integer parameter
        public Deck(int zero) {
        }

        // constructor for a full deck
        public Deck() {
                int value = 1;
                switch (value) {
                        case 1:
                                this.cardArr.add(new Card(1, "spades"));
                                this.cardArr.add(new Card(1, "clubs"));
                                this.cardArr.add(new Card(1, "hearts"));
                                this.cardArr.add(new Card(1, "diamonds"));

                        case 2:
                                this.cardArr.add(new Card(2, "spades"));
                                this.cardArr.add(new Card(2, "clubs"));
                                this.cardArr.add(new Card(2, "hearts"));
                                this.cardArr.add(new Card(2, "diamonds"));

                        case 3:
                                this.cardArr.add(new Card(3, "spades"));
                                this.cardArr.add(new Card(3, "clubs"));
                                this.cardArr.add(new Card(3, "hearts"));
                                this.cardArr.add(new Card(3, "diamonds"));

                        case 4:
                                this.cardArr.add(new Card(4, "spades"));
                                this.cardArr.add(new Card(4, "clubs"));
                                this.cardArr.add(new Card(4, "hearts"));
                                this.cardArr.add(new Card(4, "diamonds"));

                        case 5:
                                this.cardArr.add(new Card(5, "spades"));
                                this.cardArr.add(new Card(5, "clubs"));
                                this.cardArr.add(new Card(5, "hearts"));
                                this.cardArr.add(new Card(5, "diamonds"));

                        case 6:
                                this.cardArr.add(new Card(6, "spades"));
                                this.cardArr.add(new Card(6, "clubs"));
                                this.cardArr.add(new Card(6, "hearts"));
                                this.cardArr.add(new Card(6, "diamonds"));

                        case 7:
                                this.cardArr.add(new Card(7, "spades"));
                                this.cardArr.add(new Card(7, "clubs"));
                                this.cardArr.add(new Card(7, "hearts"));
                                this.cardArr.add(new Card(7, "diamonds"));

                        case 8:
                                this.cardArr.add(new Card(8, "spades"));
                                this.cardArr.add(new Card(8, "clubs"));
                                this.cardArr.add(new Card(8, "hearts"));
                                this.cardArr.add(new Card(8, "diamonds"));

                        case 9:
                                this.cardArr.add(new Card(9, "spades"));
                                this.cardArr.add(new Card(9, "clubs"));
                                this.cardArr.add(new Card(9, "hearts"));
                                this.cardArr.add(new Card(9, "diamonds"));

                        case 10:
                                this.cardArr.add(new Card(10, "spades"));
                                this.cardArr.add(new Card(10, "clubs"));
                                this.cardArr.add(new Card(10, "hearts"));
                                this.cardArr.add(new Card(10, "diamonds"));

                        case 11:
                                this.cardArr.add(new Card(11, "spades"));
                                this.cardArr.add(new Card(11, "clubs"));
                                this.cardArr.add(new Card(11, "hearts"));
                                this.cardArr.add(new Card(11, "diamonds"));

                        case 12:
                                this.cardArr.add(new Card(12, "spades"));
                                this.cardArr.add(new Card(12, "clubs"));
                                this.cardArr.add(new Card(12, "hearts"));
                                this.cardArr.add(new Card(12, "diamonds"));

                        case 13:
                                this.cardArr.add(new Card(13, "spades"));
                                this.cardArr.add(new Card(13, "clubs"));
                                this.cardArr.add(new Card(13, "hearts"));
                                this.cardArr.add(new Card(13, "diamonds"));

                }

        }

        // method to add a card to a deck
        public void add(Card c) {
                // if(this.searchByFields(c.getValue(), c.getSuit()) != -1) //if card is not
                // already there
                this.cardArr.add(c);
        }

        /**
         * method to remove a card c from the deck
         * NOTE: MUST pass in variable for c. Do NOT pass in "new Card(whatever)"
         * as an argument, or it will break.
         * 
         * @param c card to be removed.
         */
        public void remove(Card c) {
                this.cardArr.remove(c);
        }

        // /**
        // *
        // * @param value value to be searched for
        // * @param suit suit to be searched for
        // * @return index of card, or -1 if it is not in deck.
        // */
        // private int searchByFields(int value, String suit){
        // for(int i = 0; i < this.cardArr.size(); i++){
        // if(this.cardArr.get(i).getValue() == value){
        // if(this.cardArr.get(i).getSuit().equals(suit)){
        // return i;
        // }
        // }
        // }
        // return -1;
        // }

        /**
         * method to move a card from deck d1 to deck d2
         * NOTE: MUST pass in variable for c. Do NOT pass in "new Card(whatever)"
         * as an argument, or it will break.
         * 
         * @param d1 deck that card c is being moved FROM
         * @param d2 deck that card c is being moved TO
         * @param c  card being moved
         */
        public static void move(Deck d1, Deck d2, Card c) {
                d2.add(c);
                d1.remove(c);
        }

        /**
         * Shuffles the deck.
         */
        public void shuffle() {
                Collections.shuffle(this.cardArr);
        }
}
