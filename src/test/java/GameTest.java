import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Player player1;
    private Player player2;
    private Deck deck;
    private Game game;
    private Card card1;
    private Card card2;

    @Before
    public void before(){
        this.player1 = new Player("Ally");
        this.player2 = new Player("Jenn");
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        this.deck = new Deck();
        deck.populateDeck();
        deck.shuffleDeck();
        this.game = new Game(players, deck);
        this.card1 = new Card(CardValue.ACE,CardSuit.SPADES);
        this.card2 = new Card(CardValue.TWO,CardSuit.SPADES);
    }

    @Test
    public void playerOneCanWin(){
        player1.setCard(card2);
        player2.setCard(card1);
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        this.game = new Game(players,deck);
        System.out.println(this.game.getWinner());
        assertEquals("Ally wins! They drew a 2 of Spades", this.game.getWinner());
    }

    @Test
    public void playerTwoCanWin(){
        player1.setCard(card1);
        player2.setCard(card2);
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        this.game = new Game(players,deck);
        System.out.println(this.game.getWinner());
        assertEquals("Jenn wins! They drew a 2 of Spades", this.game.getWinner());
    }

    @Test
    public void canBeDraw(){
        player1.setCard(card2);
        player2.setCard(card2);
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        this.game = new Game(players,deck);
        System.out.println(this.game.getWinner());
        assertEquals("It's a draw!  Ally and Jenn drew a 2", this.game.getWinner());
    }

}
