public class Player {
    private int score;
    public Deck hand;

    public Player(){
        score = 0;          //player starts with empty deck and no score. 
        hand = new Deck(0); //Cards will be dealt at the start of the game (from Rummy class)
    }

    public void addPoint(){
        this.score++;
    }

     

}

