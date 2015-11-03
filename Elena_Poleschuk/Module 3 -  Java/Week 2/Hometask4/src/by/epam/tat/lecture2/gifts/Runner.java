package by.epam.tat.lecture2.gifts;

public class Runner {

	public static void main(String[] args) {
		Gifts gift = new Gifts();
		boolean lollipop;
		
		
		Communicator.out("Add sweets");
		while (Communicator.getFlag("________________\nPress \"Y\" to add a new sweet. Press any other kay to stop") == true) {
			boolean answer;
			answer = Communicator.getFlag("Press \"Y\" to add Sugar Candy. Press any other kay to add Chocolate Candy");
			Communicator.out("Enter name");
			String sweetName = Communicator.stringScanner();
			Communicator.out("Enter producer");
			String sweetProducer = Communicator.stringScanner();
			Communicator.out("Enter price");
			int price = Communicator.intScanner();
			Communicator.out("Enter weight");
			int weight = Communicator.intScanner();
			if (answer == true){
				if (Communicator.getFlag("Enter \"Y\" if the sweet with stick. Press any other kay if not") == true){
					lollipop = true;
				} else {
					lollipop = false;
				}
				gift.addSweet(new SugarCandy(sweetName, sweetProducer, price, weight, lollipop));	
			} else {
				gift.addSweet(new ChocolateCandy(sweetName, sweetProducer, price, weight));
			}
		}
		
		
		Communicator.out("-------------\nAdded sweets");
		gift.showCollection();
	}

}