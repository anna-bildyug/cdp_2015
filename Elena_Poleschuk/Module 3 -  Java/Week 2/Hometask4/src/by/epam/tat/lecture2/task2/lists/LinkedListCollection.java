package by.epam.tat.lecture2.task2.lists;

import java.util.LinkedList;
import java.util.Random;

public class LinkedListCollection {
	private LinkedList<Integer> linkedList = new LinkedList<Integer>();

	public void fillCollection(int value){
		for (int i = 0; i < value; i++){
			Integer d = new Random().nextInt();
			linkedList.add(d);
		}
	}
	// add
	public void addValue(int value){
		linkedList.add(value);		
	}
	
	
	// search element
	public boolean searchValue(int value){
		boolean valueFound = false;
		for (Integer d : linkedList){
			if (d.equals(value)){
				valueFound = true;
			}
		}
		return valueFound;
	}
	
	//delete element
	public boolean removeValue(int value){
		boolean valueIsDeleted = false;
		for (Integer d : linkedList){
			if (d.equals(value)){
				linkedList.remove(d);
				valueIsDeleted = true;
			}
		}
		return valueIsDeleted;
	}
}
