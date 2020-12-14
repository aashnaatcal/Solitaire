// DONE
public class DeckTester {

	public static void main(String[] args) {
		
		Deck card_deck = new Deck();
		
		Card card1 = new Card("J", 11, true);
		
		Card middle = new Card("2", 2, true);
		
		Card card2 = new Card("J", 12, true);

		
		card_deck.addCard(card1);
		card_deck.addCard(middle);
		card_deck.addCard(card2);
		

		System.out.println(card_deck.getNextCardIndex("J", 1));
	}

}
