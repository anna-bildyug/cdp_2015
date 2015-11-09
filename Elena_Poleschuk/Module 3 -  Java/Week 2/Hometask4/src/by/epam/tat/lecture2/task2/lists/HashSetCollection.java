package by.epam.tat.lecture2.task2.lists;

import java.util.HashSet;
import java.util.Random;

public class HashSetCollection {

	private HashSet<Integer> hashSet = new HashSet<Integer>();

	public void fillCollection(int value){
		for (int i = 0; i < value; i++){
			Integer d = new Random().nextInt();
			hashSet.add(d);
		}
	}
	// add
	public void addValue(int value){
		hashSet.add(value);		
	}
	
	
	// search element
	public boolean searchValue(int value){
		boolean valueFound = false;
		for (Integer d : hashSet){
			if (d.equals(value)){
				valueFound = true;
			}
		}
		return valueFound;
	}
	
	//delete element
	public boolean removeValue(int value){
		boolean valueIsDeleted = false;
		if (hashSet.remove(value)){
			valueIsDeleted = true;
		}
		return valueIsDeleted;
	}
	
}
