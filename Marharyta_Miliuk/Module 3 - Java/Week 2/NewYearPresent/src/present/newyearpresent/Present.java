package present.newyearpresent;
import java.util.*;

import present.console.InputOutputStreams;
import sweets.newyearpresent.*;


public class Present {
	
	public int askNumberOfCandies (){
		InputOutputStreams.printMessage("How many candies do you want?");
		return InputOutputStreams.scanNumbers();
	}
	
	public ArrayList<Object> putCandiesIntoPresent(){
		ArrayList<Object> collection = new ArrayList<Object>();
		int number = askNumberOfCandies();
		for (int i = 0; i < number; i++){
			InputOutputStreams.printMessage("Enter type of candy you want (Bar, Lollypop or Chocolate Candy)");
			String typeOfCandy = InputOutputStreams.scanMessage();
			InputOutputStreams.printMessage("Enter" + " " + (i+1)+ " " + "candy you want to add to your present");
			String nameOfCandy = InputOutputStreams.scanMessage();
			switch(typeOfCandy){
			case "Bar":
				collection.add(new Bar(nameOfCandy));
				break;
			case "Lollypop":
				collection.add(new Lollypop(nameOfCandy));
				break;
			case "Chocolate Candy":
				collection.add(new ChocolateCandy(nameOfCandy));
				break;
			default:
				InputOutputStreams.printMessage("Please, enter Bar, Lollypop or Chocolate Candy");
			}	
		}
		return collection;
			
	}

}
