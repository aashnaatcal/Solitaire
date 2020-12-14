import java.util.Scanner;

public class SpiderSolitaire {
	
	// Attributes
	public final int NUM_STACKS = 7;
	
	public final int NUM_DECKS = 5;
	
	Board board;
	
	Scanner input;
	
	// Constructor
	
	public SpiderSolitaire() {
		board = new Board(NUM_STACKS, NUM_DECKS);
		input = new Scanner(System.in);
	}
	
	// Methods
	
	public void printCommands() {
		System.out.println("\nCommands:");
		System.out.println("   move [card] [source stack] [destination stack]");
		System.out.println("   draw");
		System.out.println("   clear [stack]");
		System.out.println("   restart");
		System.out.println("   quit");
		System.out.print("> ");
	}
	
	public void play() {
		
		board.printBoard();
		
		boolean isGameOver = false;
		
		while (isGameOver == false) {
			printCommands();
			
			String command = input.next();
			
			if (command.equals("move")) {
				try {
					String symbol = input.next();
					int src = input.nextInt();
					int dest = input.nextInt();
					
					board.makeMove(symbol, src, dest);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Error. There was an input mismatch.");
				}
				
			}
			else if (command.equals("draw")) {
				board.drawCards();
			}
			
			else if (command.equals("clear")) {
				try {
					int index = input.nextInt();
					board.clear(index);
				} catch (Exception e) {
					System.out.println("Error. There was an input mismatch.");
				}
			}
			else if (command.equals("restart")) {
				board = new Board(NUM_STACKS, NUM_DECKS);
			}
			else if (command.equals("quit")) {
				System.out.println("Goodbye!");
				System.exit(0);
			}
			else {
				System.out.println("Invalid command.");
			}
			
			board.printBoard();
			
			if (board.isEmpty() == true) {
				isGameOver = true;
			}
		}
		
		System.out.println("Congratulations! You win.");
	}

}
