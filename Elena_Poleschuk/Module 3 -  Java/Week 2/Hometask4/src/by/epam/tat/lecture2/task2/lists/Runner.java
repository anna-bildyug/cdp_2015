package by.epam.tat.lecture2.task2.lists;

import by.epam.tat.lecture2.task1.utils.Communicator;

/**
 * 2.	Sets (HashSet vs TreeSet);
 * 
 * @author Elena
 * 
 */
public class Runner {
	

	public static void compareMaps(int numberValue, int valueAdd, int valueSearch, int valueDelete){
		long timeStart, timeFinish, timeWorking;
		boolean valueFound, valueIsDeleted;
		//HashMap
				HashMapCollection hashMap = new HashMapCollection();
				hashMap.fillCollection(numberValue);
				//add
				timeStart = System.currentTimeMillis();
				hashMap.addValue(valueAdd);
				timeFinish = System.currentTimeMillis();
				timeWorking = timeFinish - timeStart;
				Communicator.out("hashMap: time for adding: " + timeWorking + "ms");
				//search
				timeStart = System.currentTimeMillis();
				valueFound = hashMap.searchValue(valueSearch);
				timeFinish = System.currentTimeMillis();
				timeWorking = timeFinish - timeStart;
				if (valueFound){
					Communicator.out("hashMap: value is found. Time for searching: " + timeWorking + "ms");
				} else {
					Communicator.out("hashMap: value is not found. Time for searching: " + timeWorking + "ms");
				}	
			//	remove
				timeStart = System.currentTimeMillis();
				valueIsDeleted = hashMap.removeValue(valueDelete);
				timeFinish = System.currentTimeMillis();
				timeWorking = timeFinish - timeStart;
				if (valueIsDeleted){
					Communicator.out("hashMap: value is deleted. Time for deleting: " + timeWorking + "ms");
				} else {
					Communicator.out("hashMap: value is not found in the collection. Time for deleting: " + timeWorking + "ms");
				}	
				
				//TreeMap
				TreeMapCollection treeMap = new TreeMapCollection();
				treeMap.fillCollection(numberValue);
				//add
				timeStart = System.currentTimeMillis();
				treeMap.addValue(valueAdd);
				timeFinish = System.currentTimeMillis();
				timeWorking = timeFinish - timeStart;
				Communicator.out("treeMap: time for adding: " + timeWorking + "ms");
				//search
				timeStart = System.currentTimeMillis();
				valueFound = treeMap.searchValue(valueSearch);
				timeFinish = System.currentTimeMillis();
				timeWorking = timeFinish - timeStart;
				if (valueFound){
					Communicator.out("treeMap: value is found. Time for searching: " + timeWorking + "ms");
				} else {
					Communicator.out("treeMap: value is not found. Time for searching: " + timeWorking + "ms");
				}	
			//	remove
				timeStart = System.currentTimeMillis();
				valueIsDeleted = treeMap.removeValue(valueDelete);
				timeFinish = System.currentTimeMillis();
				timeWorking = timeFinish - timeStart;
				if (valueIsDeleted){
					Communicator.out("treeMap: value is deleted. Time for deleting: " + timeWorking + "ms");
				} else {
					Communicator.out("treeMap: value is not found in the collection. Time for deleting: " + timeWorking + "ms");
				}	
	}
	
	public static void compareSets(int numberValue, int valueAdd, int valueSearch, int valueDelete){
		long timeStart, timeFinish, timeWorking;
		boolean valueFound, valueIsDeleted;
		// HashSet
				HashSetCollection hashSet = new HashSetCollection();
				hashSet.fillCollection(numberValue);
				//add
				timeStart = System.currentTimeMillis();
				hashSet.addValue(valueAdd);
				timeFinish = System.currentTimeMillis();
				timeWorking = timeFinish - timeStart;
				Communicator.out("HashSet: time for adding: " + timeWorking + "ms");
				//search
				timeStart = System.currentTimeMillis();
				valueFound = hashSet.searchValue(valueSearch);
				timeFinish = System.currentTimeMillis();
				timeWorking = timeFinish - timeStart;
				if (valueFound){
					Communicator.out("HashSet: value is found. Time for searching: " + timeWorking + "ms");
				} else {
					Communicator.out("HashSet: value is not found. Time for searching: " + timeWorking + "ms");
				}	
			//	remove
				timeStart = System.currentTimeMillis();
				valueIsDeleted = hashSet.removeValue(valueDelete);
				timeFinish = System.currentTimeMillis();
				timeWorking = timeFinish - timeStart;
				if (valueIsDeleted){
					Communicator.out("HashSet: value is deleted. Time for deleting: " + timeWorking + "ms");
				} else {
					Communicator.out("HashSet: value is not found in the collection. Time for deleting: " + timeWorking + "ms");
				}			
				
				// TreeSet
				TreeSetCollection treeSet = new TreeSetCollection();
				treeSet.fillCollection(numberValue);
				//add
				timeStart = System.currentTimeMillis();
				treeSet.addValue(valueAdd);
				timeFinish = System.currentTimeMillis();
				timeWorking = timeFinish - timeStart;
				Communicator.out("treeSet: time for adding: " + timeWorking + "ms");
				//search
				timeStart = System.currentTimeMillis();
				valueFound = treeSet.searchValue(valueSearch);
				timeFinish = System.currentTimeMillis();
				timeWorking = timeFinish - timeStart;
				if (valueFound){
					Communicator.out("treeSet: value is found. Time for searching: " + timeWorking + "ms");
				} else {
					Communicator.out("treeSet: value is not found. Time for searching: " + timeWorking + "ms");
				}	
			//	remove
				timeStart = System.currentTimeMillis();
				valueIsDeleted = treeSet.removeValue(valueDelete);
				timeFinish = System.currentTimeMillis();
				timeWorking = timeFinish - timeStart;
				if (valueIsDeleted){
					Communicator.out("treeSet: value is deleted. Time for deleting: " + timeWorking + "ms");
				} else {
					Communicator.out("treeSet: value is not found in the collection. Time for deleting: " + timeWorking + "ms");
				}	
				
	}
	
	public static void compareLists(int numberValue, int valueAdd, int valueSearch, int valueDelete){
		long timeStart, timeFinish, timeWorking;
		boolean valueFound, valueIsDeleted;
		//ArrayList
				ArrayListCollection arrayList = new ArrayListCollection();
				arrayList.fillCollection(numberValue);
				//add
				timeStart = System.currentTimeMillis();
				arrayList.addValue(valueAdd);
				timeFinish = System.currentTimeMillis();
				timeWorking = timeFinish - timeStart;
				Communicator.out("arrayList: time for adding: " + timeWorking + "ms");
				//search
				timeStart = System.currentTimeMillis();
				valueFound = arrayList.searchValue(valueSearch);
				timeFinish = System.currentTimeMillis();
				timeWorking = timeFinish - timeStart;
				if (valueFound){
					Communicator.out("arrayList: value is found. Time for searching: " + timeWorking + "ms");
				} else {
					Communicator.out("arrayList: value is not found. Time for searching: " + timeWorking + "ms");
				}	
			//	remove
				timeStart = System.currentTimeMillis();
				valueIsDeleted = arrayList.removeValue(valueDelete);
				timeFinish = System.currentTimeMillis();
				timeWorking = timeFinish - timeStart;
				if (valueIsDeleted){
					Communicator.out("arrayList: value is deleted. Time for searching: " + timeWorking + "ms");
				} else {
					Communicator.out("arrayList: value is not found in the collection. Time for searching: " + timeWorking + "ms");
				}	
				
				//LinkedList
				LinkedListCollection linkedList = new LinkedListCollection();
				linkedList.fillCollection(numberValue);
				//add
				timeStart = System.currentTimeMillis();
				linkedList.addValue(valueAdd);
				timeFinish = System.currentTimeMillis();
				timeWorking = timeFinish - timeStart;
				Communicator.out("linkedList: time for adding: " + timeWorking + "ms");
				//search
				timeStart = System.currentTimeMillis();
				valueFound = linkedList.searchValue(valueSearch);
				timeFinish = System.currentTimeMillis();
				timeWorking = timeFinish - timeStart;
				if (valueFound){
					Communicator.out("linkedList: value is found. Time for searching: " + timeWorking + "ms");
				} else {
					Communicator.out("linkedList: value is not found. Time for searching: " + timeWorking + "ms");
				}	
			//	remove
				timeStart = System.currentTimeMillis();
				valueIsDeleted = linkedList.removeValue(valueDelete);
				timeFinish = System.currentTimeMillis();
				timeWorking = timeFinish - timeStart;
				if (valueIsDeleted){
					Communicator.out("linkedList: value is deleted. Time for searching: " + timeWorking + "ms");
				} else {
					Communicator.out("linkedList: value is not found in the collection. Time for searching: " + timeWorking + "ms");
				}	
				
	}
		
	
	public static void main(String[] args) {
		int numberValue, valueAdd, valueSearch, valueDelete;
		
		Communicator.out("Enter namber of values in collections");
		numberValue = Communicator.intScanner();
		Communicator.out("Enter value for adding");
		valueAdd = Communicator.intScanner();
		Communicator.out("Enter value for searching");
		valueSearch = Communicator.intScanner();
		Communicator.out("Enter value for deleting");
		valueDelete = Communicator.intScanner();
		
		compareMaps(numberValue, valueAdd, valueSearch, valueDelete);
		Communicator.out("--------");
		compareSets(numberValue, valueAdd, valueSearch, valueDelete);
		Communicator.out("--------");
		compareLists(numberValue, valueAdd, valueSearch, valueDelete);
		
	}
}
