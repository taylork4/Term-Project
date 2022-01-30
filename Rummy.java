import java.util.*;
public class Rummy {

    private int[] deck;
    private int[] discard;
    private boolean gameInProg;
    //private Player player;

    public Rummy() {
        deck = new int[51];
        discard = new int[51];
        gameInProg = true;
    }
    public static void main(String[] args) {
        System.out.println("Getting progress");
    }
}