package by.epam.tat.lecture2.task1.objects;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import by.epam.tat.lecture2.task1.utils.Communicator;
import by.epam.tat.lecture2.task1.utils.NameComparator;
import by.epam.tat.lecture2.task1.utils.PriceComparator;
import by.epam.tat.lecture2.task1.utils.WeightComparator;


public class Gift {	
	// collection
	private List<Sweets> sweetCollection = new ArrayList<Sweets>();
	
	
	// add sweet to gift
	/*public void addSweet (Sweets sweet){
		sweetCollection.add(sweet);
	}*/
	
	
	public void addSweet(String sweetName, String sweetProducer, int price, int weight, boolean lollipop, String flavour){
		if (flavour != null){
			sweetCollection.add(new SugarCandy(sweetName, sweetProducer, price, weight, lollipop, flavour));
		}else{
			sweetCollection.add(new ChocolateCandy(sweetName, sweetProducer, price, weight));
		}
	}
	
	
	
	//take the collection as matrix
	public String[] takeCollectionMatrix(){
		int n = sweetCollection.size();
		int row = 0;
		String[] collection = new String[n];
		 for (Sweets i : sweetCollection){
			 collection[row] = i.toString();
			 row++;
		 }
		return collection;
	}
	

	//show the collection
	public void printGiftInfo(){
		 if(sweetCollection.isEmpty())
		 {
			 Communicator.out("There are no sweets in the gift"); 
		 }else {
			 for (Sweets i : sweetCollection){
				 Communicator.out(i.toString());
			 }
		}
	}
	
	
	// define the gift's weight 
	public int getSumWeight(){
		int sumWeight = 0;
		 if(sweetCollection.isEmpty())
		 {
			 Communicator.out("There are no sweets in the gift"); 
		 }else {
			for (Sweets i : sweetCollection){
				sumWeight = sumWeight + i.getWeight();
			}
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
