package be.pxl.collections.opdracht1;

public class Card implements Comparable<Card> {
	private Color color;
	private Value value;

	public Card(Color c, Value v) {
		color = c;
		value = v;
	}

	public Color getColor() {
		return color;
	}

	public Value getValue() {
		return value;
	}

	@Override
	public int compareTo(Card o) {
		return this.color.getOrder() == o.color.getOrder() ? this.value.getOrder() - o.value.getOrder()
				: this.color.getOrder() - o.color.getOrder();
	}
}
