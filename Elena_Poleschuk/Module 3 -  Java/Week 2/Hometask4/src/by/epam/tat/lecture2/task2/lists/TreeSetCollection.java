package by.epam.tat.lecture2.task2.lists;

import java.util.Random;
import java.util.TreeSet;

public class TreeSetCollection {
	private TreeSet<Integer> treeSet = new TreeSet<Integer>();

	public void fillCollection(int value){
		for (int i = 0; i < value; i++){
			Integer d = new Random().nextInt();
			treeSet.add(d);
		}
	}
	// add
	public void addValue(int value){
		treeSet.add(value);		
	}
	
	
	// search element
	public boolean searchValue(int value){
		boolean valueFound = false;
		for (Integer d : treeSet){
			if (d.equals(value)){
				valueFound = true;
			}
		}
		return valueFound;
	}
	
	//delete element
	public boolean removeValue(int value){
		boolean valueIsDeleted = false;
		if (treeSet.remove(value)){
			valueIsDeleted = true;
		}
		return valueIsDeleted;
	}
}

