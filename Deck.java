import java.util.ArrayList;
import java.util.Arrays;

public class Deck {
	
	// Parameters
	
	ArrayList<Card> cards;
	
	// Constructor
	
	public Deck() {
		cards = new ArrayList<Card>();
	}

	// Methods
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void removeCard(int index) {
		cards.remove(index);
	}
	
	public Card getCard(int index) {
		return cards.get(index);
	}
	
	
	public int getSize() {
		return cards.size();
	}
	
	public ArrayList<Card> getList() {
		return cards;
	}
	
	public void flipAll(boolean flipDirection) {
		for (int i = 0; i < cards.size(); i++) {
			Card at_index = cards.get(i);
			at_index.setFaceUp(flipDirection);
		}
	}
	
	public boolean areAllFaceUp() {
		for (int i = 0; i < cards.size(); i++) {
			Card at_index = cards.get(i);
			if (at_index.isFaceUp() == false) {
				return false;
			}
		}
		return true;
		
	}
	
	public boolean isRun() {
		
		if (cards.size() == 1) {
			return true;
		}

		for (int i = cards.size() - 1; i >= 1; i--) {
			Card c = cards.get(i);
			Card d = cards.get(i - 1);
			if (c.getValue() != d.getValue() - 1) {
				return false;
			}
			if (c.isFaceUp() == false || d.isFaceUp() == false) {
				return false;
			}
		}
		
		return true;
		
	}

	public Card getTop() {
		if (cards.size() > 0) {
			return cards.get(cards.size() - 1);
		}
		else {
			return null;
		}
		
	}
	
	public Card getBottom() {
		if (cards.size() > 0) {
			return cards.get(0);
		}
		else {
			return null;
		}
		
	}
	
	@Override
	public String toString() {
		String str = new String();
		
		str += "{";
		
		for (int i = 0; i < cards.size(); i++) {
			
			if (cards.get(i).isFaceUp() == false) {
				str += 'X';
			}
			else {
				str += cards.get(i).getSymbol();
			}
			
			
			if (i != cards.size() - 1) {
				str += ", ";
			}
		}
		
		
		str += "}";
		
		return str;
	}
	
	public void sort() {
		
		boolean isSorted = false;
		int lastUnsorted = cards.size() - 1;
		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < lastUnsorted; i++) {
				if (cards.get(i).compareTo(cards.get(i + 1)) > 0) {
					Card temp = cards.get(i);
					cards.set(i, cards.get(i+1));
					cards.set(i+1, temp);
					isSorted = false;
				}

			}
			
			lastUnsorted--;
		}
		
	}
	
	public boolean contains(String symbol) {
		
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getSymbol().equals(symbol) == true) {
				if (cards.get(i).isFaceUp() == true) {
					return true;
				}
			}
		}
		
		return false;
		
	}
	
	public int numOf(String symbol) {
		int counter = 0;
		
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getSymbol().equals(symbol) == true) {
				if (cards.get(i).isFaceUp() == true) {
					counter += 1;
				}
			}
		}
		
		return counter;
	}
	
	public Card getNextCard(String symbol, int counter) {
		int count = 0;
		
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getSymbol().equals(symbol) == true) {
				if (cards.get(i).isFaceUp() == true) {
					count += 1;
					if (counter == count) {
						return cards.get(i);
					}
					
				}
			}
		}
		
		return null;
	}
	
	public int getNextCardIndex(String symbol, int counter) {
		int count = 0;
		
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getSymbol().equals(symbol) == true) {
				if (cards.get(i).isFaceUp() == true) {
					count += 1;
					if (counter == count) {
						return i;
					}
					
				}
			}
		}
		
		return -1;
	}
	
	public int getIndexOf(String symbol) {
		
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getSymbol().equals(symbol) == true) {
				if (cards.get(i).isFaceUp() == true) {
					return i;
				}
				
			}
		}
		
		return -1;
		
	}
	
	public void shuffle() {
		
		for (int i = 0; i < cards.size(); i++) {
			int position = (int) (cards.size() * Math.random());
			
			if (position == i) {
				continue;
			}
			
			Card value = cards.get(i);
			cards.set(i, cards.get(position));
			cards.set(position, value);
			
		}
		
	}


}
