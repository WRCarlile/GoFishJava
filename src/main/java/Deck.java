import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Deck {
  private static final String[] SUITS = {"Spades", "Clubs", "Hearts", "Diamonds"};
  private static final String[] VALUES = {
    "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"
  };

  private ArrayList<Card> mCards;

  public Deck() {
    mCards = new ArrayList<Card>();
    for (String suit : SUITS) {
      for ( String value : VALUES) {
        Card newCard = new Card(suit, value);
        mCards.add(newCard);
      }
    }
  }

  public ArrayList<Card> getCards() {
    return mCards;
  }

  public void dealHand(Player player) {
    while(player.getHand().size() < 7) {
      player.addCard(mCards.get(0));
      mCards.remove(0);
    }
  }

  public void shuffle() {
    Collections.shuffle(mCards);
  }

}
