import java.util.*;

public class playerDeck {
	Random rndm = new Random();

	ArrayList<Card> myDeck = new ArrayList<Card>();
	
	public void printMyDeck() {
		for (int q = 0; q < myDeck.size(); q++) {
			System.out.println(myDeck.get(q).title);
		}
	}
	
	public void shuffleMyDeck() {
		if (0 < myDeck.size()) {
			for (int i = -100; i < rndm.nextInt(200); i++) {
			int x = rndm.nextInt(myDeck.size());
			int y = rndm.nextInt(myDeck.size());
		
			Collections.swap(myDeck, x, y);
			}
		}
		else {
			System.out.println("There's nothing in your deck!");
		}
	}
	
}
