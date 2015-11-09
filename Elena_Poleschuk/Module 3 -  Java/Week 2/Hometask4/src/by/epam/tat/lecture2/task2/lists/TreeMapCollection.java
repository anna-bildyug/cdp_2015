package by.epam.tat.lecture2.task2.lists;

import java.util.TreeMap;
import java.util.Random;

public class TreeMapCollection {
	private TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();

	public void fillCollection(int value){
		for (int i = 0; i < value; i++){
			Integer d = new Random().nextInt();
			treeMap.put(i, d);
		}
	}
	// add
	public void addValue(int value){
		treeMap.put(treeMap.size(), value);		
	}
	
	
	// search element
	public boolean searchValue(int value){
		boolean valueFound = false;
			if (treeMap.containsValue(value)){
				valueFound = true;
			}
		return valueFound;
	}
	
	//delete element
	public boolean removeValue(int value){
		boolean valueIsDeleted = false;
			if (treeMap.values().remove(value)){
				valueIsDeleted = true;
			}
		return valueIsDeleted;
	}
}
