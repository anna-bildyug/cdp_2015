package by.epam.tat.lecture2.task2.lists;

import java.util.HashSet;
import java.util.Random;

public class TreeSetList {
	HashSet<Integer> treeSet = new HashSet<Integer>();

	public void createHashSet(int value){
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
}
