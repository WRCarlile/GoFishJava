import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class DeckTest {

  @Test
  public void deck_initializesCorrectly() {
    Deck testDeck = new Deck();
    assertEquals(true, testDeck instanceof Deck);
  }

  @Test
  public void getCards_initializesWithCardsList_true() {
    Deck testDeck = new Deck();
    assertEquals(true, testDeck.getCards() instanceof ArrayList);
  }

  @Test
  public void getCards_initalizesWith52Cards_52() {
    Deck testDeck = new Deck();
    assertEquals(52, testDeck.getCards().size());
  }

  @Test
  public void getCards_cardsAreInitalizedWithSuitsAndValues_AceOfSpades() {
    Deck testDeck = new Deck();
    Card aceOfSpades = testDeck.getCards().get(0);
    assertEquals("Ace of Spades", aceOfSpades.name());
  }

  @Test
  public void getCards_deckContains52UniqueCards_kingOfDiamonds() {
    Deck testDeck = new Deck();
    Card kingOfDiamonds = testDeck.getCards().get(51);
    assertEquals("King of Diamonds", kingOfDiamonds.name());
  }

  @Test
  public void getCards_handContainsOneCardInPostionIndex_4_OfSpades() {
    Deck testDeck = new Deck();
    Player testPlayer = new Player();
    testDeck.dealHand(testPlayer);
    Card fourOfSpades = testPlayer.getHand().get(3);
    assertEquals("4 of Spades", fourOfSpades.name());
  }

  @Test
  public void getCards_dealFirstCardThenDealSecond_8_OfSpades() {
    Deck testDeck = new Deck();
    Player testPlayer = new Player();
    testDeck.dealHand(testPlayer);
    Card eightOfSpades = testDeck.getCards().get(0);
    assertEquals("8 of Spades", eightOfSpades.name());
  }

  @Test
  public void shuffle_deckChangesOrderWhenShuffled_String() {
    Deck testDeck = new Deck();
    Card kingOfDiamonds = testDeck.getCards().get(51);
    assertEquals("King of Diamonds", kingOfDiamonds.name());
    testDeck.shuffle();
    Card lastCard = testDeck.getCards().get(51);
    assertEquals(false, lastCard.name().equals("King of Diamonds"));
  }
}
