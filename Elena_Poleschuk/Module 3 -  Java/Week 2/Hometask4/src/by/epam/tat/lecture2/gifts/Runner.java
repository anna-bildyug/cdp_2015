package by.epam.tat.lecture2.gifts;

import java.util.ArrayList;

public class Runner {

	public static void main(String[] args) {
		
		Communicator communictor = new Communicator();
		ArrayList<Sweets> sweetsList;
		sweetsList = communictor.addSweet();
		
		
		// show the collection
		System.out.println("Added sweets:");
		for (Sweets d : sweetsList){
			System.out.print("d ");
		}
	}

}
