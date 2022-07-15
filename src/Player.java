import java.util.ArrayList;

public class Player {
private int sum = 100;
private ArrayList<Card> hand = new ArrayList<>();


public void bet (int bet) {
   sum = bet - sum;
}

public void add(Card c) {
   hand.add(c);
}

public void updateSum(int winnings) {
  sum += winnings;
}

public int returnValue() {
   int handValue = 0;
   for (int i = 0; i < hand.size(); i++) {
   handValue+= hand.get(i).cardValue;
   }
   return handValue;
}

public void reset() {
hand.clear();
}
}