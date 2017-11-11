package be.pxl.collections.opdracht1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class Deck {
	private Deque<Card> deck;

	public Deck() {
		ArrayList<Card> listOfCards = new ArrayList<>();
		for (Color c : Color.values()) {
			for (Value v : Value.values()) {
				listOfCards.add(new Card(c, v));
			}
		}

		Collections.shuffle(listOfCards);

		deck = new ArrayDeque<>(listOfCards);
	}

	public int getDeckSize() {
		return deck.size();
	}

	public Card dealCard() {
		return deck.pollLast();
	}

	public String showDeck() {
		String deckText = deck.stream().map(c -> c.color.toString() + c.value.toString()).reduce("",
				(acc, el) -> acc + el);
		return deckText;
	}

}
