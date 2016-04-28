public class Game {

  private Deck deck = new Deck();
  private Player player1 = new Player();
  private Player player2 = new Player();
  private boolean gameOver = false;
  private int whoseTurn = 1;
  private Card pickedCard;


  public Game() {
    deck.dealHand(player1);
    deck.dealHand(player2);
  }

  public Player getPlayerOne() {
    return player1;
  }

  public Player getPlayerTwo() {
    return player2;
  }

  // public void startGame() {
  //   while(gameOver == false) {
  //     this.gameTurn();
  //   }
  // }

  public void gameTurn(String playerCardChoice) {

    if (whoseTurn == 1) {
      for(Card card : player2.getHand()) {
        if (playerCardChoice.equals(card.getValue())) {
          pickedCard = card;
        }
      }
    }

    if(pickedCard != null) {
      player1.addCard(pickedCard);
      player2.removeCard(pickedCard);
    }
    // else {
    //   for(Card card : player1.getHand()) {
    //     if (playerCardChoice.equals(card.getValue())) {
    //       player2.addCard(player1.getHand().indexOf(card));
    //       player1.removeCard(player1.getHand().indexOf(card));
    //     }
    //   }
    // }

    if(whoseTurn == 1) {
      whoseTurn = 2;
    } else {
      whoseTurn = 1;
    }

  }

}
