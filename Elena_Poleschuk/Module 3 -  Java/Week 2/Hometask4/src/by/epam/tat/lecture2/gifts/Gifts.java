package by.epam.tat.lecture2.gifts;

import java.util.ArrayList;
import java.util.Iterator;

public class Gifts {	
	// collection
	ArrayList<Sweets> sweetCollection = new ArrayList<Sweets>();
	Iterator<Sweets> it = sweetCollection.iterator(); 
	
	// add sweet to gift
	public void addSweet (Sweets sweet){
		int counter = 0;
		if (it.hasNext() == false){
			sweetCollection.add(0, sweet);
		} else {
			while(it.hasNext()){
				counter++;
			}
			sweetCollection.add(counter, sweet);
		}
		sweetCollection.add(sweet);
	}
	
	// remove sweet from the gift
	public void removeSweet (Sweets sweet){
		while (it.hasNext()){
			if (it.next() == sweet)
				sweetCollection.remove(sweet);	
		}		
	}

	//show the collection
	public void showCollection(){
		for (int i = 1; i < sweetCollection.size(); i++){
			System.out.print(sweetCollection.get(i).getInfo());
		}
	}
	// define the gift's weight 
	public int getWeight(){
		int sumWeight = 0;
		while (it.hasNext()){
			sumWeight += getWeight();
		}
		return sumWeight;
	}
		
	
	//find particular sweet in gift
	public Sweets giveSweetByName(String sweetName){
		int counter = 0;
		Sweets foundSweet = null;
		while (it.hasNext()){
			foundSweet = sweetCollection.get(counter);
			if (foundSweet.getSweetName() == sweetName){
				break;
			} else {
				counter++;
			}
		}
		return foundSweet;
	}	
}
