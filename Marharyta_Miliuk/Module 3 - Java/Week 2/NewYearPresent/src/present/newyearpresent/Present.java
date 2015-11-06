package present.newyearpresent;

import java.util.*;
import java.util.stream.Collectors;
import console.newyearpresent.InputOutputStreams;
import sweets.newyearpresent.*;


public class Present{
	
	public static ArrayList<Sweets> collection = new ArrayList<Sweets>();//creating public field for collection
	
	public static Comparator<Sweets> SweetsNameComparator = new Comparator<Sweets>() {//creating and defining comparator field to use it in the sorting
		
	    public int compare(Sweets candy1, Sweets candy2) {

	    String candyName1 = candy1.getName().toUpperCase();
	    String candyName2 = candy2.getName().toUpperCase();

	    return candyName1.compareTo(candyName2);
	    }
	 };
	
	public int askNumberOfCandies (){//creating method do define number of candies to put into present
		
		System.out.println("How many candies do you want?");
		
		return InputOutputStreams.scanNumbers();
	}
	
	public void sortCollection(){//creating method to sort candies in the present by names alphabetically
		
	    Collections.sort(collection, SweetsNameComparator);
	         for (Sweets e:collection){
		         InputOutputStreams.printObject(e);
	         }	
    }
	
    public void findCandy (){//creating method to find candy with exact name entered by user and print it to the console
    
        InputOutputStreams.printMessage("Which candy do you want to eat?");
        String candyName = InputOutputStreams.scanMessage();
    
         List<Sweets> foundCandy = 
    	    collection.stream().
    	    filter((sweets)-> sweets.getName()
    	    		.equals((candyName)))
    	    .collect(Collectors.toList());
    
       InputOutputStreams.printCollection(foundCandy);
    }
    
	public void findPresentsWeight (){//creating method to count presents weight
		
    	int findPresentWeight = 0;
    	
    	     for (Sweets candy: collection){
    		     findPresentWeight += candy.getWeight();
    	     }
    	 InputOutputStreams.printMessage("The weight of your present is: " + findPresentWeight);
    }
}