import java.util.ArrayList;

class Player {

private ArrayList<Card> mHand = new ArrayList(); // Does this work when we remove '= new ArrayList()'?

public ArrayList<Card> getHand() {
  return mHand;
}

public void addCard(Card card) {
  mHand.add(card);
}

}
