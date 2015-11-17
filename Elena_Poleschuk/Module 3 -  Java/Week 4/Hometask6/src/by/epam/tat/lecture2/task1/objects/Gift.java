package by.epam.tat.lecture2.task1.objects;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import by.epam.tat.lecture2.task1.utils.Communicator;
import by.epam.tat.lecture2.task1.utils.comparators.NameComparator;
import by.epam.tat.lecture2.task1.utils.comparators.PriceComparator;
import by.epam.tat.lecture2.task1.utils.comparators.WeightComparator;
import by.epam.tat.lecture2.task1.utils.exceptions.EmptyCollectionException;


public class Gift {	
	// collection
	private List<Sweets> sweetCollection = new ArrayList<Sweets>();
	
	// get sweet collection
	public List<Sweets> getSweets(){
		return sweetCollection;
	}
	
	// check for empty collection
	public void checkGiftEmpty() throws EmptyCollectionException{
		if (sweetCollection.isEmpty()){
			throw new EmptyCollectionException("Error: The gift is empty");
		}
	}
	
	// get size of gift
	public int getGiftSize(){
		return sweetCollection.size();
	}
	
	// add sweet to gift
	public void addSweet (Sweets sweet){
		sweetCollection.add(sweet);
	}
	
	//remove one sweet from gift
	public void removeSweet(String sweetName){
		boolean nameExist = false;
		for (Sweets i : sweetCollection){
			if (i.getSweetName().equals(sweetName)){
				sweetCollection.remove(i);
				nameExist = true;
				break;
			}
		}
		if (nameExist == false){
			Communicator.out("There is no sweet with " + "\"" + sweetName + "\"" +" name.");
		}
	}
	
	//remove all sweets from gift
	public void removeAllSweets(){
		sweetCollection.clear();
	}
	
	
	//show the collection
	public void printGiftInfo(){
		try{
			checkGiftEmpty();
			for (Sweets i : sweetCollection){
			Communicator.out(i.toString());
			} 
		}catch (EmptyCollectionException e){
				Communicator.out(e.getMessage());
		}
	}
	
	// define the gift's weight 
	public int getSumWeight(){
		int sumWeight = 0;
		try{
			checkGiftEmpty();
			for (Sweets i : sweetCollection){
				sumWeight = sumWeight + i.getWeight();	
			}
		 }catch (EmptyCollectionException e){
				Communicator.out(e.getMessage());
		}
		return sumWeight;
	}

	//find particular sweet in gift 
	public void giveSweetByName(String sweetName){
		boolean nameExist = false;
		for (Sweets i : sweetCollection){
			if (i.getSweetName().equals(sweetName)){
				Communicator.out(i.toString());
				nameExist = true;
			}
		}
		if (nameExist == false){
			Communicator.out("There is no sweet with " + "\"" + sweetName + "\"" +" name.");
		}
		
	}	
	
	
	// sorting
	public void sortByName(){
		Collections.sort(sweetCollection, new NameComparator()); 
		printGiftInfo();
	}
	
	public void sortByWeight(){
		Collections.sort(sweetCollection, new WeightComparator()); 
		printGiftInfo();

	}	
	
	public void sortByPrice(){
		Collections.sort(sweetCollection, new PriceComparator()); 
		printGiftInfo();
	}


	
		
}
