import java.util.*;

public class Deck {
        /**************************************************************************************************************************************************************************************
         * The Deck class constructs a deck of cards, as well as allows for cards to be
         * removed and added from deck to deck. It also is capable of shuffling the card
         * deck.
         * 
         * @author Noah Arden
         * @author Owen Carroll
         * @author Kyle Taylor
         * @version 2/28/2022
         */

        /**************************************************************************************************************************************************************************************
         * Instance Variables
         */
        public ArrayList<Card> cardArr = new ArrayList<Card>();

        /**************************************************************************************************************************************************************************************
         * Default constructor of the Card class that creates a full deck.
         */
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

        /**************************************************************************************************************************************************************************************
         * Constructor of the Card class that takes an integer as a parameter to
         * create an empty deck.
         * 
         * @param zero - Integer value that
         */
        public Deck(int zero) {
        }

        /**************************************************************************************************************************************************************************************
         * The add(Card c) method adds a Card c to the deck.
         * NOTE: MUST pass in variable for c. Do NOT pass in "new Card(whatever)"
         * as an argument, or it will break.
         * 
         * @param c - Card to be added.
         */
        public void add(Card c) {
                // if(this.searchByFields(c.getValue(), c.getSuit()) != -1) //if card is not
                // already there
                this.cardArr.add(c);
        }

        /**************************************************************************************************************************************************************************************
         * The remove(Card c) method removes a Card c from the deck.
         * NOTE: MUST pass in variable for c. Do NOT pass in "new Card(whatever)"
         * as an argument, or it will break.
         * 
         * @param c - Card to be removed.
         */
        public void remove(Card c) {
                this.cardArr.remove(c);
        }

        /**************************************************************************************************************************************************************************************
         * The move(Deck d1, Deck d2, Card c) method moves a Card from Deck d1 to Deck
         * d2.
         * NOTE: MUST pass in variable for c. Do NOT pass in "new Card(whatever)"
         * as an argument, or it will break.
         * 
         * @param d1 - Deck that Card c is being moved FROM
         * @param d2 - Deck that Card c is being moved TO
         * @param c  - Card that is being moved
         */
        public static void move(Deck d1, Deck d2, Card c) {
                d2.add(c);
                d1.remove(c);
        }

        /**************************************************************************************************************************************************************************************
         * The shuffle() method shuffles a deck of cards
         */
        public void shuffle() {
                Collections.shuffle(this.cardArr);
        }

        /**
         * @return String
         */
        public String toString() {
                String deckAsString = "";
                for (Card card : cardArr) {
                        switch (card.getValue()) {
                                case 1:
                                        deckAsString += "ace";
                                        break;
                                case 11:
                                        deckAsString += "jack";
                                        break;
                                case 12:
                                        deckAsString += "queen";
                                        break;
                                case 13:
                                        deckAsString += "king";
                                        break;
                                default:
                                        deckAsString += card.getValue();

                        }
                        deckAsString += " of ";
                        deckAsString += card.getSuit();
                        deckAsString += ", ";
                }
                return deckAsString;
        }

        /**************************************************************************************************************************************************************************************
         * Methods no longer in use
         */

        // /**************************************************************************************************************************************************************************************
        // * The searchByFields(int value, String suit) searches for an integer value
        // *
        // * @param value - Integer value to be searched for
        // * @param suit - String suit to be searched for
        // *
        // * @return index of card, or -1 if it is not in deck.
        // */
        // private int searchByFields(int value, String suit) {
        // for (int i = 0; i < this.cardArr.size(); i++) {
        // if (this.cardArr.get(i).getValue() == value) {
        // if (this.cardArr.get(i).getSuit().equals(suit)) {
        // return i;
        // }
        // }
        // }
        // return -1;
        // }
}
