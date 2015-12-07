package by.epam.cdp.java.nypresent;

import java.util.*;
import java.util.stream.Collectors;
import by.epam.cdp.java.nypresent.beans.*;
import by.epam.cdp.java.nypresent.validation.NoSuchCandyException;

public class Present {

	private List<Sweets> collection = new ArrayList<Sweets>();
	
	private Comparator<Sweets> SweetsNameComparator = new Comparator<Sweets>() {
		public int compare(Sweets candy1, Sweets candy2) {

			String candyName1 = candy1.getName().toUpperCase();
			String candyName2 = candy2.getName().toUpperCase();

			return candyName1.compareTo(candyName2);
		}
	};

	public List<Sweets> getCollection() {
		return collection;
	}
	
	public void setCollection(List<Sweets> collection) {
		this.collection = collection;
	}
	
	public void addCandy(Sweets candy){
		collection.add(candy);
	}

	public void sortCollectionByName() {
		Collections.sort(getCollection(), SweetsNameComparator);
	}

	public List<Sweets> findCandyByName(String candyName) throws NoSuchCandyException {

		List<Sweets> foundCandy = getCollection().stream().filter((sweets) -> sweets.getName().equals((candyName)))
				.collect(Collectors.toList());

		if (!foundCandy.isEmpty()) {

			return foundCandy;
		} else {
			throw new NoSuchCandyException();
		}
	}

	public int getPresentsWeight() {// creating method to count presents weight

		int presentWeight = 0;

		for (Sweets candy : getCollection()) {
			presentWeight += candy.getWeight();
		}
		return presentWeight;
	}

	@Override
	public String toString() {
		return "Present: " + getCollection() + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((collection == null) ? 0 : collection.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Present other = (Present) obj;
		if (collection == null) {
			if (other.collection != null)
				return false;
		} else if (!collection.equals(other.collection))
			return false;
		return true;
	}
}