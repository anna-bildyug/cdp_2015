package by.epam.tat.task7.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.epam.tat.task7.utils.Communicator;
import by.epam.tat.task7.utils.comparators.NameComparator;
import by.epam.tat.task7.utils.comparators.PriceComparator;
import by.epam.tat.task7.utils.comparators.WeightComparator;
import by.epam.tat.task7.utils.exceptions.EmptyCollectionException;
import by.epam.tat.task7.utils.exceptions.ExceedCountSweetsExeption;

public class Gift {
	// collection
	private List<Sweets> sweetCollection = new ArrayList<Sweets>();

	// get sweet collection
	public List<Sweets> getSweets() {
		return sweetCollection;
	}

	// check for empty collection
	public boolean isGiftEmpty() {
		return (sweetCollection.isEmpty());
	}

	// get size of gift
	public int getGiftSize() {
		return sweetCollection.size();
	}

	// add sweet to gift
	public void addSweet(Sweets sweet) throws ExceedCountSweetsExeption {
		int maxCount = 10;
		if (getGiftSize() < 10) {
			sweetCollection.add(sweet);
		} else {
			throw new ExceedCountSweetsExeption(maxCount);
		}
	}

	// remove one sweet from gift
	public void removeSweet(String sweetName) throws EmptyCollectionException {
		boolean nameExist = false;
		if (isGiftEmpty() == false) {
			for (Sweets i : sweetCollection) {
				if (i.getSweetName().equals(sweetName)) {
					sweetCollection.remove(i);
					nameExist = true;
					break;
				}
			}
			if (nameExist == false) {
				Communicator.out("There is no sweet with " + "\"" + sweetName + "\"" + " name.");
			}
		} else {
			throw new EmptyCollectionException();
		}
	}

	// remove all sweets from gift
	public void removeAllSweets() {
		sweetCollection.clear();
	}

	// show the collection
	public void printGiftInfo() {
		for (Sweets i : sweetCollection) {
			Communicator.out(i.toString());
		}
	}

	// define the gift's weight
	public int getSumWeight() throws EmptyCollectionException {
		int sumWeight = 0;
		if (isGiftEmpty()) {
			throw new EmptyCollectionException();
		} else {
			for (Sweets i : sweetCollection) {
				sumWeight = sumWeight + i.getWeight();
			}
		}
		return sumWeight;
	}

	// find particular sweet in gift
	public boolean findSweetByName(String sweetName) {
		boolean nameExist = false;
		for (Sweets i : sweetCollection) {
			if (i.getSweetName().equals(sweetName)) {
				Communicator.out(i.toString());
				nameExist = true;
			}
		}
		if (nameExist == false) {
			Communicator.out("There is no sweet with " + "\"" + sweetName + "\"" + " name.");
		}
		return nameExist;
	}

	// sorting
	public void sortByName() {
		Collections.sort(sweetCollection, new NameComparator());
		printGiftInfo();
	}

	public void sortByWeight() {
		Collections.sort(sweetCollection, new WeightComparator());
		printGiftInfo();

	}

	public void sortByPrice() {
		Collections.sort(sweetCollection, new PriceComparator());
		printGiftInfo();
	}

}
