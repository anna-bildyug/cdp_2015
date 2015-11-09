package by.epam.tat.lecture2.task2.lists;

import java.util.Random;
import java.util.ArrayList;

public class ArrayListCollection {
	private ArrayList<Integer> arrayList = new ArrayList<Integer>();

	public void fillCollection(int value){
		for (int i = 0; i < value; i++){
			Integer d = new Random().nextInt();
			arrayList.add(d);
		}
	}
	// add
	public void addValue(int value){
		arrayList.add(value);		
	}
	
	
	// search element
	public boolean searchValue(int value){
		boolean valueFound = false;
		for (Integer d : arrayList){
			if (d.equals(value)){
				valueFound = true;
			}
		}
		return valueFound;
	}
	
	//delete element
	public boolean removeValue(int value){
		boolean valueIsDeleted = false;
		int temp = 0;
		temp = arrayList.indexOf(value);
		if (temp >= 0)	{
			arrayList.remove(temp);
			valueIsDeleted = true;
		}
		return valueIsDeleted;
	}

	
	public void view (){
		for (Integer d : arrayList){
			System.out.print(d + " ");
		}
	}
}
