package by.epam.tat.lecture2.task1.main;

import by.epam.tat.lecture2.task1.objects.Gift;
import by.epam.tat.lecture2.task1.utils.Communicator;
import by.epam.tat.lecture2.task1.utils.IOFile;


public class Runner {
	public static int sortGift(){
		int action;
		while(true){
			action = Communicator.intScanner();	
			if (action < 4 && action > 0 ){
				break;
			}else {
				Communicator.out("Enter existed number of action");
			}
		}
		return action;
	}
	
	public static int selectMenuAction(){
		int action;
		while(true){
			action = Communicator.intScanner();	
			if (action < 9 && action > 0 ){
				break;
			}else {
				Communicator.out("Enter existed number of action");
			}
		}
		return action;
	}
	
	
	public static void main(String[] args) {
		Gift gift = new Gift();
		int action;
		String sweetName;
		String sweetProducer;
		int price;
		int weight;
		boolean lollipop;
		String flavour;
		final String file = "log.txt";
		boolean exit = false;
		Communicator.openScanner();
		while (exit == false){
			// menu
			Communicator.out("\n---MENU--- \nPress number of action");
			Communicator.out("1. Add sweets");
			Communicator.out("2. View Sweets in the Gift");
			Communicator.out("3. Calculate Weight of the Gift");
			Communicator.out("4. Sort Sweets in the Gift");
			Communicator.out("5. Find sweet");
			Communicator.out("6. Save gift into file");
			Communicator.out("7. Open saved gift");
			Communicator.out("8. Exit");
			action = selectMenuAction();
			switch (action)
			{
				case 1:
					Communicator.out("--Add sweets--");
					boolean addingContinue = true;
					while (addingContinue) {
						boolean answer;
						Communicator.out("Press \"Y\" to add Sugar Candy. Press any other kay to add Chocolate Candy");
						answer = Communicator.getFlag();	
						Communicator.stringScanner(); // Consume newline left-over
						Communicator.out("Enter name");
						sweetName = Communicator.stringScanner();
						Communicator.out("Enter producer");
						sweetProducer = Communicator.stringScanner();
						Communicator.out("Enter price");
						price = Communicator.intScanner();
						Communicator.out("Enter weight");
						weight = Communicator.intScanner();
						if (answer == true){
							Communicator.out("Enter \"Y\" if the sweet with stick. Press any other kay if not");
							if (Communicator.getFlag()){
								lollipop = true;
							} else {
								lollipop = false;
							}
							Communicator.stringScanner(); // Consume newline left-over
							Communicator.out("Enter flavour of candy");
							flavour = Communicator.stringScanner();
							gift.addSweet(sweetName, sweetProducer, price, weight, lollipop, flavour);	
						} else {
							gift.addSweet(sweetName, sweetProducer, price, weight, false, null);
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
					switch (sortGift())
					{
						case 1:
							gift.sortByName();
							break;
						case 2:
							gift.sortByPrice();
							break;			
						default:
							gift.sortByWeight();	
					};
					break;		
				case 5:
					Communicator.out("--Find sweet--");
					Communicator.stringScanner(); // Consume newline left-over
					Communicator.out("Enter a name of sweet to find other information about it:");
					gift.giveSweetByName(Communicator.stringScanner());
					break;
					
				case 6:
					Communicator.out("--Save gift into file--");
					IOFile saveGiftInfoToFile = new IOFile();
					saveGiftInfoToFile.saveInfo(file, gift.takeCollectionMatrix());
					Communicator.out("The gift is saved");
					break;
				case 7:
					Communicator.out("--Open saved gift--");
					IOFile exportGiftFromInfo = new IOFile();
					String[][] giftCollectionMatrix = exportGiftFromInfo.getSavedGiftInfo(file);
					for (int i = 0; i < giftCollectionMatrix.length;i++){
						sweetName = giftCollectionMatrix[i][0];
						sweetProducer = giftCollectionMatrix[i][1];
						price = Integer.parseInt(giftCollectionMatrix[i][2]);
						weight = Integer.parseInt(giftCollectionMatrix[i][3]);
						lollipop = Boolean.parseBoolean(giftCollectionMatrix[i][3]);
						flavour = giftCollectionMatrix[i][3];
						gift.addSweet(sweetName, sweetProducer, price, weight, lollipop, flavour);	
					}
					;

					Communicator.out("You can work with previously saved gift");
					break;		
				default:
					exit = true;
					Communicator.out("--Exit--");
			}
			
		}
		Communicator.closeScanner();

	}
}