public class War {
	
	static int rounds = 0;
	static int wars = 0;
	static int b = 0;
	static boolean run = true;
	
	public static void war(DeckOfCards d, playerDeck p1, playerDeck p2) {

		wars++;
		
		b = b + 2;
		if (b  > p1.myDeck.size() - 1 || b > p2.myDeck.size() - 1) {
			System.out.println("No more cards to play war against! Removing the cards!");
			for (int i = 0; i < b - 1; i++) {
				if (p1.myDeck.size() > 0) {
					d.removeCardFromMyDeck(p1);
				}
				if (p2.myDeck.size() > 0) {
					d.removeCardFromMyDeck(p2);
				}
				
			}
		}
		else {
			if (p1.myDeck.size() == 0 || p2.myDeck.size() == 0) {
				run = false;
			}
			else if (p1.myDeck.get(b).num > p2.myDeck.get(b).num) {
				for (int i = 0; i < b; i++) {
					d.removeCardFromMyDeck(p2);
					d.addCardToMyDeck(p1);
					rounds++;
				}

			}
			else if (p1.myDeck.get(b).num < p2.myDeck.get(b).num) {
				for (int i = 0; i < b; i++) {
					d.removeCardFromMyDeck(p1);
					d.addCardToMyDeck(p2);
					rounds++;
				}
			}
			else if (p1.myDeck.get(b).num == p2.myDeck.get(b).num) {
				war(d, p1, p2);
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		DeckOfCards theDeck = new DeckOfCards();

		theDeck.shuffleOriginalDeck();
		
		playerDeck playerOne = new playerDeck();
		playerDeck playerTwo = new playerDeck();
		
		for (int i = 0; i < 26; i++) {
			theDeck.addCardToMyDeck(playerOne);
			theDeck.addCardToMyDeck(playerTwo);
		}
		
		while (run == true) {
			if (playerOne.myDeck.size() == 0 || playerTwo.myDeck.size() == 0) {
				break;
			}
			else if (playerOne.myDeck.get(0).num > playerTwo.myDeck.get(0).num) {
				theDeck.removeCardFromMyDeck(playerTwo);
				theDeck.addCardToMyDeck(playerOne);
				rounds++;
			}
			else if (playerOne.myDeck.get(0).num < playerTwo.myDeck.get(0).num) {
				theDeck.removeCardFromMyDeck(playerOne);
				theDeck.addCardToMyDeck(playerTwo);
				rounds++;
			}
			else if (playerOne.myDeck.get(0).num == playerTwo.myDeck.get(0).num) {
				war(theDeck, playerOne, playerTwo);
				
			}
		}
		
		System.out.println(" ");
		System.out.println("Rounds: " + rounds);
		System.out.println(" ");
		System.out.println("Wars: " + wars);
		System.out.println(" ");
		if (playerOne.myDeck.size() == 0) {
			System.out.println("Player Two Won!");
		}
		else if (playerTwo.myDeck.size() == 0) {
			System.out.println("Player One Won!");
		}


	}
	
}
