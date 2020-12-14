// DONE
public class CardTester {

	public static void main(String[] args) {
		
		Card first_card = new Card("J", 11, true);
		
		System.out.println(first_card.getSymbol());
		System.out.println(first_card.getValue());
		System.out.println(first_card.isFaceUp());
		
		first_card.setFaceUp(false);
		System.out.println(first_card.isFaceUp());
		
		Card second_card = new Card("2", 2, true);
		System.out.println(first_card.equals(second_card));
		
		Card third_card = new Card("J", 11, true);
		System.out.println(first_card.equals(third_card));
		
		System.out.println(first_card.compareTo(second_card));
		
	}

}
