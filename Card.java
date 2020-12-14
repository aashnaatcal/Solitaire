public class Card {
	
	// Parameters
	
	String symbol;
	int value;
	boolean isFaceUp;
	
	// Constructor
	
	public Card(String symbol, int value, boolean isFaceUp) {
		
		this.symbol = symbol;
		this.value = value;
		this.isFaceUp = isFaceUp;
		
	}
	
	// Methods
	
	public String getSymbol() {
		return this.symbol;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public boolean isFaceUp() {
		return this.isFaceUp;
	}
	
	public void setFaceUp(boolean change) {
		this.isFaceUp = change;
	}
	
	/**
	 * Returns whether or not this Card is equal to another.
	 * 
	 * @param other the Card to compare to
	 * @return true if this card is equal to other
	 */
	
	public boolean equals(Card other) {
		if (this.value == other.value) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int compareTo(Card other) {
		return (this.value - other.value);
	}
	

}
