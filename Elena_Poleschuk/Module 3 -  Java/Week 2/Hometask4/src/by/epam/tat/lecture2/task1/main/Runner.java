package by.epam.tat.lecture2.task1.main;

import by.epam.tat.lecture2.task1.objects.ChocolateCandy;
import by.epam.tat.lecture2.task1.objects.Gift;
import by.epam.tat.lecture2.task1.objects.SugarCandy;
import by.epam.tat.lecture2.task1.utils.Communicator;

public class Runner {

	public static void main(String[] args) {
		Gift gift = new Gift();
		int action;
		boolean exit = false;
		while (exit == false){
			// menu
			Communicator.out("\n---MENU--- \nPress number of action");
			Communicator.out("1. Add sweets");
			Communicator.out("2. View Sweets in the Gift");
			Communicator.out("3. Calculate Weight of the Gift");
			Communicator.out("4. Sort Sweets in the Gift");
			Communicator.out("5. Find sweet");
			Communicator.out("6. Exit");
			while(true){
				action = Communicator.intScanner();	
				if (action < 7){
					break;
				}else {
					Communicator.out("Enter existed number of action");
				}
			}
			
			
			switch (action)
			{
				case 1:
					Communicator.out("--Add sweets--");
					boolean addingContinue = true;
					while (addingContinue) {
						boolean answer;
						Communicator.out("Press \"Y\" to add Sugar Candy. Press any other kay to add Chocolate Candy");
						answer = Communicator.getFlag();
						Communicator.out("Enter name");
						String sweetName = Communicator.stringScanner();
						Communicator.out("Enter producer");
						String sweetProducer = Communicator.stringScanner();
						Communicator.out("Enter price");
						int price = Communicator.intScanner();
						Communicator.out("Enter weight");
						int weight = Communicator.intScanner();
						if (answer == true){
							boolean lollipop;
							String flavour;
							Communicator.out("Enter \"Y\" if the sweet with stick. Press any other kay if not");
							if (Communicator.getFlag() == true){
								lollipop = true;
							} else {
								lollipop = false;
							}
							Communicator.out("Enter flavour of candy");
							flavour = Communicator.stringScanner();
							gift.addSweet(new SugarCandy(sweetName, sweetProducer, price, weight, lollipop, flavour));	
						} else {
							gift.addSweet(new ChocolateCandy(sweetName, sweetProducer, price, weight));
						}
						Communicator.out("________________\nPress \"Y\" to add a new sweet. Press any other kay to stop");
						addingContinue = Communicator.getFlag();
					}
					
					break;
				case 2:
					Communicator.out("--View Sweets in the Gift--");
					gift.printGiftInfo();
					 
					break;			
				case 3:
					Communicator.out("--Calculate Weight of the Gift--");
					Communicator.out("Weight of the gift: " + gift.getSumWeight() + "g.");
					
					break;	
				case 4:
					Communicator.out("--Sort Sweets in the Gift--");
					Communicator.out("Select type of sorting press number: ");
					Communicator.out("1. by Name");
					Communicator.out("2. by Price");
					Communicator.out("3. by Weigth");
					while(true){
						action = Communicator.intScanner();	
						if (action < 4){
							break;
						}else {
							Communicator.out("Enter existed number of action");
						}
						switch (action)
						{
							case 1:
								gift.sortByName();
								break;
							case 2:
								gift.sortByPrice();
								break;			
							default:
								gift.sortByWeight();
						}
					}
					break;		
				case 5:
					Communicator.out("--Find sweet--");
					Communicator.out("Enter a name of sweet to find other information about it:");
					gift.giveSweetByName(Communicator.stringScanner());
					break;
				default:
					exit = true;
					Communicator.out("--Exit--");
			}
		}
	}
		
}