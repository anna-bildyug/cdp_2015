package by.epam.tat.lecture2.task2.lists;

import by.epam.tat.lecture2.task1.utils.Communicator;

/**
 * 2.	Sets (HashSet vs TreeSet);
 * 
 * @author Elena
 * 
 */
public class Runner {
	public static void main(String[] args) {
		long timeStart;
		long timeFinish;
		long timeHashWorking;
		boolean valueFound;
		int numberValue, valueAdd, valueDelete;
		
		Communicator.out("Enter namber of values in collections");
		numberValue = Communicator.intScanner();
		Communicator.out("Enter value for adding");
		valueAdd = Communicator.intScanner();
		Communicator.out("Enter value for deleting");
		valueDelete = Communicator.intScanner();
		
		// HashSet
		HashSetList hashSet = new HashSetList();
		hashSet.createHashSet(numberValue);
		Communicator.out("HashSet: collection is created");
		Communicator.out("HashSet: start");
		timeStart = System.currentTimeMillis();
		hashSet.addValue(valueAdd);
		Communicator.out("HashSet: value is add");
		valueFound = hashSet.searchValue(valueDelete);
		if (valueFound){
			Communicator.out("HashSet: value is found");
		} else {
			Communicator.out("HashSet: value is not found");
		}	
		timeFinish = System.currentTimeMillis();
		Communicator.out("HashSet: finish");
		timeHashWorking = timeFinish - timeStart;
		Communicator.out("Time for HashSet: " + timeHashWorking + "ms\n");
		
		// TreeSet
		HashSetList treeSet = new HashSetList();
		treeSet.createHashSet(numberValue);
		Communicator.out("TreeSet: collection is created");
		Communicator.out("TreeSet: start");
		timeStart = System.currentTimeMillis();
		treeSet.addValue(valueAdd);
		Communicator.out("TreeSet: value is add");
		valueFound = treeSet.searchValue(valueDelete);
		if (valueFound){
			Communicator.out("TreeSet: value is found");
		} else {
			Communicator.out ("TreeSet: value is not found");
		}	
		timeFinish = System.currentTimeMillis();
		Communicator.out("TreeSet: finish");
		timeHashWorking = timeFinish - timeStart;
		Communicator.out("Time for TreeSet: " + timeHashWorking + "ms");
		

	}

}
