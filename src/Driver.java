import java.util.*;
public class Driver {
	
	public static void main(String args[]) {
		
		DeckOfCards theDeck = new DeckOfCards();
		
		theDeck.shuffleOriginalDeck();
		
		playerDeck playerOne = new playerDeck();
		playerDeck playerTwo = new playerDeck();

		for (int i = 0; i < 7; i++) {
			theDeck.addCardToMyDeck(playerOne);
			theDeck.addCardToMyDeck(playerTwo);
		}
		
		//playerOne.printMyDeck();
		
		//System.out.println(" ");
		
		//playerTwo.printMyDeck();
		
		//System.out.println(" ");
		
		//System.out.println("Cards in Original Deck: " + theDeck.originalDeck.size());
		
		}
}
