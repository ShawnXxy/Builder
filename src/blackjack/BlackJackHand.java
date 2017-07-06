package blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackJackHand extends Hand {
	@Override
	public int score() {
		List<Integer> scores = possibleScores();
		int maxUnder = Integer.MIN_VALUE; // max score <= 21
		int minOver = Integer.MAX_VALUE; // min core > 21
		for (int s : scores) {
			if (s > 21 && s < minOver) {
				minOver = s;
			} else if (s <= 21 && s > maxUnder) {
				maxUnder = s;
			} 
		}
//		return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
		if (maxUnder == Integer.MIN_VALUE) {
			return minOver;
		} else {
			return maxUnder;
		}
	}
	
	private List<Integer> possibleScores() {
		List<Integer> scores = new ArrayList<>();
		for (Card c : cards) {
			updateScores(c, scores);
		}
		return scores;
	}
	private void updateScores( Card c, List<Integer> scores) {
		final int[] toAdd = getScores(c);
		if (scores.isEmpty()) {
			for (int score : toAdd) {
				scores.add(score);
			}
		} else {
			final int length = scores.size();
			for (int i = 0; i < length; i++) {
				int oldScore = scores.get(i);
				scores.set(i, oldScore + toAdd[0]);
				for (int j = 1; j < toAdd.length; j++) {
					scores.add(oldScore + toAdd[j]);
				}
			}
		}
	}
	private int[] getScores (Card c) {
		if (c.getValue() > 1) {
			return new int[] {Math.min(c.getValue(), 10)};
		} else { // Ace
			return new int[] {1, 11};
		}
	}
	
	public boolean busted() {
		return score() > 21;
	}
	public boolean isBlackJack() {
		if (cards.size() != 2) {
			return false;
		}
		Card first =cards.get(0);
		Card second = cards.get(1);
		return isAce(first) && isFaceCard(second) || (isAce(second) && isFaceCard(first));
	}
	private static boolean isAce (Card c) {
		return c.getValue() == 1;
	}
	private static boolean isFaceCard (Card c) {
		return c.getValue() >= 11 && c.getValue() <= 13;
	}
}
