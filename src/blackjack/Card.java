package blackjack;

public class Card {
	private int faceValue; // 1 for A, 11 for J, 12 for Q, 13 for K
	private Suit suit;
	public Card (int faceValue, Suit suit) {
		this.faceValue = faceValue;
		this.suit = suit;
	}
	public int getValue() {
		return faceValue;
	}
	public Suit getSuit() {
		return suit;
	}
}
