import java.util.*;
public class DeckOfCards {
	Random rndm = new Random();
	
	ArrayList<Card> originalDeck = new ArrayList<Card>();
	String[] cardTypes = {"Spades", "Hearts", "Clubs", "Diamonds"};
	String[] cardNames = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	
	public DeckOfCards() {
		for (int q = 0; q < 4; q++) {
			for (int i = 1; i < 14; i++) {
				Card acard = new Card(i, cardTypes[q], cardNames[i - 1] + " of " + cardTypes[q]);
				originalDeck.add(acard);
			}
		}
	}
	
	String[] cardType = {"Spades", "Hearts", "Clubs", "Diamonds"};

	public void printOriginalDeck() {
		for (int q = 0; q < originalDeck.size(); q++) {
			System.out.println(originalDeck.get(q).title);
		}
	}
	

	public void shuffleOriginalDeck() {	
		for (int i = -100; i < rndm.nextInt(200); i++) {
			int x = rndm.nextInt(originalDeck.size());
			int y = rndm.nextInt(originalDeck.size());
			
			Collections.swap(originalDeck, x, y);
		}
	}
	
	public void addCardToMyDeck(playerDeck deck) {
		deck.myDeck.add(originalDeck.get(0));
		originalDeck.remove(0);
	}
	
	public void removeCardFromMyDeck(playerDeck deck) {
		originalDeck.add(deck.myDeck.get(0));
		deck.myDeck.remove(0);
	}
	
	
}
	

	
