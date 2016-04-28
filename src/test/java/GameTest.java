import org.junit.*;
import static org.junit.Assert.*;

public class GameTest {

  @Test
  public void gameTurn_matchCard_String() {
    Game newGame = new Game();
    newGame.gameTurn("Queen");
    System.out.print(newGame.getPlayerOne().getHand().size());
    System.out.print(newGame.getPlayerTwo().getHand().size());
    assertEquals("Queen of Spades", newGame.getPlayerOne().getHand().get(7).name());
  }

}
