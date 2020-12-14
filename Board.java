import java.util.ArrayList;

public class Board {

	// Parameters
	
	ArrayList<Deck> stacks;
	Deck drawPile = new Deck();
	ArrayList<Deck> completedStacks = new ArrayList<Deck>();
	
	// Constructors
	public Board(int numStacks, int numDecks) {
		stacks = new ArrayList<Deck>();
		
		for (int i = 0; i < numStacks; i++) {
			Deck d = new Deck();
			stacks.add(d);
		}
		
		for (int i = 0; i < numDecks; i++) {
			
			drawPile.addCard(new Card("A", 1, false));
            drawPile.addCard(new Card("2", 2, false));
            drawPile.addCard(new Card("3", 3, false));
            drawPile.addCard(new Card("4", 4, false));
            drawPile.addCard(new Card("5", 5, false));
            drawPile.addCard(new Card("6", 6, false));
            drawPile.addCard(new Card("7", 7, false));
            drawPile.addCard(new Card("8", 8, false));
            drawPile.addCard(new Card("9", 9, false));
            drawPile.addCard(new Card("10", 10, false));
            drawPile.addCard(new Card("J", 11, false));
            drawPile.addCard(new Card("Q", 12, false));
            drawPile.addCard(new Card("K", 13, false));
		}
		
		drawPile.shuffle();
		
		while (drawPile.getSize() > ((13*numDecks)/2)) {
			
			int i = 0;
			
			while (i < numStacks) {
				Card temp = drawPile.getTop();
				stacks.get(i).addCard(temp);
				drawPile.removeCard(drawPile.getSize() - 1);
				i++;
			}
			
			while (i == numStacks - 1) {
				i = 0;
			}
			
		}
		
		int counter = 0;
		while (counter < numStacks) {
			stacks.get(counter).getTop().setFaceUp(true);
			counter++;
		}
		
	}
	
	
	// Methods
	// makeMove, drawCards, isEmpty (if all the stacks & the draw is empty)
	
	
	public void makeMove(String symbol, int src, int dest) {
		
		if (stacks.get(src - 1).contains(symbol) == false) {
			System.out.println("Error finding the card. Not making any changes.");
			return;
		}
		else {
			
			int numOfPossibleCard = stacks.get(src - 1).numOf(symbol);
			int counter = 1;
			
			while (counter <= numOfPossibleCard) {
				
				Card possibleCard = stacks.get(src - 1).getNextCard(symbol, counter);
				int index = stacks.get(src - 1).getNextCardIndex(symbol, counter);
				
				if (index == -1) {
					if (counter == numOfPossibleCard) {
						System.out.println("Error finding the card. Not making any changes.");
						return;
					} 
					else {
						counter++;
						continue;
					}
				}
				
				Deck temp = new Deck();
				
				for (int i = index; i <= stacks.get(src - 1).getSize() - 1; i++) {
					temp.addCard(stacks.get(src - 1).getCard(i));
					
				}
				
				
				if (temp.isRun() == false) {
					if (counter == numOfPossibleCard) {
						System.out.println("Cannot do because it is not a run.");
						return;
					} 
					else {
						System.out.println("Is not a run. Checking for another card.");
						counter++;
						continue;
					}
					
				}
								
				if (temp.areAllFaceUp() == false) {
					if (counter == numOfPossibleCard) {
						System.out.println("Error. Not a valid run.");
						return;
					} 
					else {
						counter++;
						continue;
					}

				}
				
				
				if (stacks.get(dest - 1).getSize() == 0) {
					int size = stacks.get(src - 1).getSize();
					for (int i = index; i < size; i++) {
						stacks.get(dest - 1).addCard(stacks.get(src - 1).getCard(index));
						stacks.get(src - 1).removeCard(index);
					}
					stacks.get(src - 1).getTop().setFaceUp(true);
					return;
				}
				else if (stacks.get(dest - 1).getTop().getValue() == stacks.get(src - 1).getCard(index).getValue() + 1) {
					int size = stacks.get(src - 1).getSize();
					for (int i = index; i < size; i++) {
						stacks.get(dest - 1).addCard(stacks.get(src - 1).getCard(index));
						stacks.get(src - 1).removeCard(index);
					}
					stacks.get(src - 1).getTop().setFaceUp(true);
					return;
				}
				else {
					if (counter == numOfPossibleCard) {
						System.out.println("Error. Cannot be moved because it does not create a longer run.");						
						return;
					} 
					else {
						counter++;
						continue;
					}
					
				}
				
			}
			
		}	
		
	}
	
	public void drawCards() {
		
		for (int i = 0; i < stacks.size(); i++) {
			if (stacks.get(i).getSize() == 0) {
				System.out.println("Cannot draw cards because there are empty stacks.");
			}
		}
		
		if (drawPile.getSize() == 0) {
			System.out.println("Cannot draw more cards since the draw pile is empty.");
		}
		
		for (int i = 0; i < stacks.size(); i++) {
			if (drawPile.getSize() == 0) {
				break;
			}
			
			Card temp = drawPile.getTop();
			temp.setFaceUp(true);
			
			stacks.get(i).addCard(temp);
			
			drawPile.removeCard(drawPile.getSize() - 1);
			
		}
	}
	
	
	
	public boolean isEmpty() {
		
		if (drawPile.getSize() != 0) {
			return false;
		}
		
		for (int i = 0; i < stacks.size(); i++) {
			if (stacks.get(i).getSize() != 0) {
				return false;
			}
		}
		
		return true;
		
	}
	
	public void clear(int sourceStack) {
		Deck d = stacks.get(sourceStack);
		
		int value = 1;
		
		for (int i = d.getSize() - 1; i >= 0; i--) {
			if (i < d.getSize() - 13) {
				break;
			}
			
			if (d.getCard(i).getValue() != value) {
				System.out.println("Invalid move. This is not a run.");
				return;
			}
			else {
				value++;
			}
		}
		
		Deck deck = new Deck();
		
		for (int i = d.getSize() - 1; i >= 0; i--) {
			if (i < d.getSize() - 13) {
				break;
			}
			else {
				deck.addCard(d.getCard(i));
				d.removeCard(i);
			}
		}
		
		completedStacks.add(deck);
		
		
	}
	

	public void printBoard() {
		
		System.out.println("Stacks:");
		
		for (int i = 0; i < stacks.size(); i++) {
			System.out.print(i+1);
			System.out.print(": ");
			System.out.println(stacks.get(i).toString());
			
			
		}
		
		System.out.println("");
		System.out.println("Draw Pile: ");
		System.out.println(drawPile.toString());
		
		System.out.println("");
		
		System.out.println("Completed Stacks:");
		
		for (int i = 0; i < completedStacks.size(); i++) {
			System.out.print(i+1);
			System.out.print(": ");
			System.out.println(completedStacks.get(i).toString());
			
			
		}
		
		
		
	}
	
	
}
