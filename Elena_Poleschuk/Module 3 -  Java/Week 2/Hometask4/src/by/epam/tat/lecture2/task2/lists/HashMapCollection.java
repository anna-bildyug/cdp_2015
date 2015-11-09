package by.epam.tat.lecture2.task2.lists;

import java.util.HashMap;
import java.util.Random;

public class HashMapCollection {
	private HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

	public void fillCollection(int value){
		for (int i = 0; i < value; i++){
			Integer d = new Random().nextInt();
			hashMap.put(i, d);
		}
	}
	// add
	public void addValue(int value){
		hashMap.put(hashMap.size(), value);		
	}
	
	
	// search element
	public boolean searchValue(int value){
		boolean valueFound = false;
			if (hashMap.containsValue(value)){
				valueFound = true;
			}
		return valueFound;
	}
	
	//delete element
	public boolean removeValue(int value){
		boolean valueIsDeleted = false;
			if (hashMap.values().remove(value)){
				valueIsDeleted = true;
			}
		return valueIsDeleted;
	}
}
