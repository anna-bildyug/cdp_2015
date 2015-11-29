package by.epam.tat.task7.main;

import java.util.List;

import by.epam.tat.task7.objects.ChocolateCandy;
import by.epam.tat.task7.objects.Gift;
import by.epam.tat.task7.objects.SugarCandy;
import by.epam.tat.task7.objects.Sweets;
import by.epam.tat.task7.utils.Communicator;
import by.epam.tat.task7.utils.DatabaseReaderSaver;
import by.epam.tat.task7.utils.FileReaderSaver;
import by.epam.tat.task7.utils.IReaderSaver;
import by.epam.tat.task7.utils.XmlReaderSaver;
import by.epam.tat.task7.utils.exceptions.EmptyCollectionException;
import by.epam.tat.task7.utils.exceptions.ExceedCountSweetsExeption;
import by.epam.tat.task7.utils.exceptions.OpeningSavedCollectionException;

public class Runner {

	public static void main(String[] args) {
		Gift gift = new Gift();
		int action, price, weight;
		String sweetName, sweetProducer, flavour;
		boolean lollipop, exit = false, answer, isSavedCollectioOpen = false;

		Communicator.openScanner();
		while (exit == false) {
			Communicator.out("\n---MENU--- \nPress number of action");
			Communicator.out("1. Add sweets");
			Communicator.out("2. View Sweets in the Gift");
			Communicator.out("3. Calculate Weight of the Gift");
			Communicator.out("4. Sort Sweets in the Gift");
			Communicator.out("5. Find sweet");
			Communicator.out("6. Save gift into file. The gift will be closed");
			Communicator.out("7. Open saved gift");
			Communicator.out("8. Remove sweet from gift");
			Communicator.out("9. Exit");
			action = Communicator.selectAction(9);
			switch (action) {
			case 1:
				Communicator.out("--Add sweets--");
				boolean addingContinue = true;
				while (addingContinue) {
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
					if (answer == true) {
						Communicator.out("Enter \"Y\" if the sweet with stick. Press any other kay if not");
						if (Communicator.getFlag()) {
							lollipop = true;
						} else {
							lollipop = false;
						}
						Communicator.stringScanner(); // Consume newline
														// left-over
						Communicator.out("Enter flavour of candy");
						flavour = Communicator.stringScanner();
						try {
							gift.addSweet(new SugarCandy(sweetName, sweetProducer, price, weight, lollipop, flavour));
						} catch (ExceedCountSweetsExeption e) {
							Communicator.out(e.getMessage());
						}
					} else {
						try {
							gift.addSweet(new ChocolateCandy(sweetName, sweetProducer, price, weight));
						} catch (ExceedCountSweetsExeption e) {
							Communicator.out(e.getMessage());
						}
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
				try {
					Communicator.out("Weight of the gift: " + gift.getSumWeight() + "g.");
				} catch (EmptyCollectionException e1) {
					Communicator.out(e1.getMessage());
				}
				break;
			case 4:
				Communicator.out("--Sort Sweets in the Gift--");
				Communicator.out("Select type of sorting press number: ");
				Communicator.out("1. by Name");
				Communicator.out("2. by Price");
				Communicator.out("3. by Weigth");
				switch (Communicator.selectAction(3)) {
				case 1:
					gift.sortByName();
					isSavedCollectioOpen = true;
					break;
				case 2:
					gift.sortByPrice();
					isSavedCollectioOpen = true;
					break;
				default:
					gift.sortByWeight();
					isSavedCollectioOpen = true;
				}
				;
				break;
			case 5:
				Communicator.out("--Find sweet--");
				Communicator.stringScanner(); // Consume newline left-over
				Communicator.out("Enter a name of sweet to find other information about it:");
				gift.findSweetByName(Communicator.stringScanner());
				break;

			case 6:
				Communicator.out("--Save gift into file--");
				FileReaderSaver saveGiftToFile = new FileReaderSaver();
				saveGiftToFile.saveGift(gift);
				gift.removeAllSweets();
				isSavedCollectioOpen = false;
				Communicator.out("The gift is saved and closed");
				break;
			case 7: // open form 1.file, 2. from DB, 3. from XML
				if (isSavedCollectioOpen == false) {
					Communicator.out("--Open saved gift--\nSelect source of the gift.");
					Communicator.out("1. from txt file.");
					Communicator.out("2. from database.");
					Communicator.out("3. from xml file.");
					IReaderSaver saver = null;
					switch (Communicator.selectAction(3)) {
					case 1:
						saver = new FileReaderSaver();
						break;
					case 2:
						saver = new DatabaseReaderSaver();
						break;
					case 3:
						saver = new XmlReaderSaver();
						break;
					}
					try {
						List<Sweets> sweets = saver.getSavedGift();
						for (Sweets i : sweets) {
							try {
								gift.addSweet(i);
							} catch (ExceedCountSweetsExeption e) {
								Communicator.out(e.getMessage());
							}
						}
						isSavedCollectioOpen = true;
						Communicator.out("--The gift is opened--");
					} catch (OpeningSavedCollectionException e) {
						Communicator.out(e.getMessage());
					}
					;
				} else {
					Communicator.out(
							"You have already opened gift. Please save current gift if you want to open another one");
				}
				;

				break;
			case 8:
				Communicator.out("--Remove sweet from gift--");
				try {
					gift.isGiftEmpty();
					Communicator.stringScanner(); // Consume newline left-over
					Communicator.out("Enter a name of sweet to remove it from the gift");
					gift.removeSweet(Communicator.stringScanner());
					Communicator.out("The sweet is removed");
				} catch (EmptyCollectionException e) {
					Communicator.out(e.getMessage());
				}
				break;
			default:

				exit = true;
				Communicator.out("--Exit--");
			}
		}
		Communicator.closeScanner();

	}
}