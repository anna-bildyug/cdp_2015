package by.epam.cdp.java.nypresent;

import java.util.*;
import java.util.stream.Collectors;

import by.epam.cdp.java.nypresent.beans.*;
import by.epam.cdp.java.nypresent.utils.InputOutputStreams;


public class Present{
	
	public ArrayList<Sweets> collection = new ArrayList<Sweets>();//creating public field for collection
	
	public Comparator<Sweets> SweetsNameComparator = new Comparator<Sweets>() {//creating and defining comparator field to use it in the sorting
		
	    public int compare(Sweets candy1, Sweets candy2) {

	    String candyName1 = candy1.getName().toUpperCase();
	    String candyName2 = candy2.getName().toUpperCase();

	    return candyName1.compareTo(candyName2);
	    }
	 };
	
	public void sortCollectionByName(){//creating method to sort candies in the present by names alphabetically
		
	    Collections.sort(collection, SweetsNameComparator);
	         for (Sweets e:collection){
		         InputOutputStreams.printObject(e);
	         }	
    }
	
    public void findCandyByName (String candyName){//creating method to find candy with exact name entered by user and print it to the console
    
         List<Sweets> foundCandy = 
    	    collection.stream().
    	    filter((sweets)-> sweets.getName()
    	    		.equals((candyName)))
    	    .collect(Collectors.toList());
    
       InputOutputStreams.printCollection(foundCandy);
    }
    
	public void getPresentsWeight (){//creating method to count presents weight
		
    	int findPresentWeight = 0;
    	
    	     for (Sweets candy: collection){
    		     findPresentWeight += candy.getWeight();
    	     }
    	 InputOutputStreams.printMessage("The weight of your present is: " + findPresentWeight);
    }
}