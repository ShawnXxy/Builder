package blackjack;

import java.util.ArrayList;
import java.util.List;

public class GameAutomator {
	private Deck deck;
	private BlackJackHand[] hands;
	private static final int HIT_UNTIL = 16;
	
	public GameAutomator (int numPlayers) {
		hands = new BlackJackHand[numPlayers];
		for (int i = 0; i < numPlayers; i++) {
			hands[i] = new BlackJackHand();
		}
	}
	
	void initDeck() {
		deck = new Deck();
		deck.shuffle();
	}
	
	boolean dealInitial() {
		for (BlackJackHand h : hands) {
			Card[]	cards = deck.dealtHand(2);
			if (cards == null) {
				return false;
			}
			h.addCards(cards);
		}
		return true;
	}
	
	List<Integer> getBlackJacks() {
		List<Integer> winners = new ArrayList<>();
		for (int i = 0; i < hands.length; i++) {
			if (hands[i].isBlackJack()) {
				winners.add(i);
			}
		}
		return winners;
	}
	
	boolean playHand (BlackJackHand hand) {
		while (hand.score() < HIT_UNTIL) {
			Card c = deck.dealCard();
			if (c == null) {
				return false;
			}
			hand.addCards(new Card[] { c });
		}
		return true;
	}
	
	boolean playAllHands() {
		for (BlackJackHand h : hands) {
			if (!playHand(h)) {
				return false;
			}
		}
		return true;
	}
	
	List<Integer> getWinners() {
		List<Integer> winners = new ArrayList<>();
		int winningScore = 0;
		for (int i = 0; i < hands.length; i++) {
			BlackJackHand hand = hands[i];
			if (!hand.busted()) {
				if (hand.score() > winningScore) {
					winningScore = hand.score();
					winners.clear();
					winners.add(i);
				} else if (hand.score() == winningScore) {
					winners.add(i);
				}
			}
		}
		return winners;
	}
	
	void printHandsAndScore() {
		for (int i = 0; i < hands.length; i++) {
			System.out.print("Hand" + i + "(" + hands[i].score() + "):");
			hands[i].print();
			System.out.println();
		}
	}
	
	public void simulate() {
		initDeck();
		
		boolean success =  dealInitial();
		if (!success) {
			System.out.println("Error: Out of cards");
		} else {
			System.out.println("--Initial--");
			printHandsAndScore();
			List<Integer> blackjacks = getBlackJacks();
			if (blackjacks.size() > 0) {
				System.out.print("Blackjack at ");
				for (int i : blackjacks) {
					System.out.print(i + " ");
				}
				System.out.println("done");
			} else {
				success = playAllHands();
				if (!success) {
					System.out.println("Error. Out of cards.");
				} else {
					System.out.println("\n--Complated Game--");
					printHandsAndScore();
					List<Integer> winners = getWinners();
					if (winners.size() > 0) {
						System.out.print("Winners: ");
						for (int i : winners) {
							System.out.print(i + " ");
						}
						System.out.println();
					} else {
						System.out.println("Draw. Allplayers have busted.");
					}
				}
			}
		}
	}
	
	public static void main (String[] args) {
		GameAutomator automator = new GameAutomator(5);
		automator.simulate();
	}
}
