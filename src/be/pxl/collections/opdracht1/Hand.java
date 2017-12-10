package be.pxl.collections.opdracht1;

import java.util.Set;
import java.util.TreeSet;

public class Hand {

	private Set<Card> hand = new TreeSet<>();

	public void addCard(Card c) {
		hand.add(c);
	}

	public boolean hasColor(Color c) {
		int numberOfSearchedColor = (int) hand.stream().filter(s -> s.getColor() == c).count();
		boolean hasColor = numberOfSearchedColor > 0 ? true : false;

		return hasColor;
	}

	public String showHand() {
		String handText = hand.stream().map(c -> c.getColor().toString() + c.getValue().toString()).reduce("",
				(acc, el) -> acc + el);
		return handText;
	}
}
