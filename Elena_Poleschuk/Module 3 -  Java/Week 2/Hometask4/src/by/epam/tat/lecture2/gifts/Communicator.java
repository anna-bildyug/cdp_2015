package by.epam.tat.lecture2.gifts;

import java.util.ArrayList;
import java.util.Scanner;

public class Communicator {
	
	public ArrayList<Sweets> addSweet(){
		boolean answerContinue = true;
		while (answerContinue){
			Scanner in = new Scanner(System.in);
			ArrayList<Sweets> sweetsList = new ArrayList<Sweets>();
			System.out.println("Press \"Y\" to create Sugar Candy. Press any other kay to create Chocolate Candy");
			String answerType = in.next();
			if (answerType.equalsIgnoreCase("y")){

				System.out.println("Enter name");
				String sweetName = in.nextLine();
				in.nextLine();  // Consume newline left-over
				System.out.println("Enter producer");
				String sweetProducer = in.nextLine();
				System.out.println("Enter price");
				int price = in.nextInt();
				System.out.println("Enter weight");
				int weight = in.nextInt();
				System.out.println("Enter \"Y\" if the sweet with stick. Press any other kay if not");
				boolean lollipop;
				in.nextLine();  // Consume newline left-over
				if (in.nextLine().equalsIgnoreCase("y")){
					lollipop = true;
				} else {
					lollipop = false;
				}
				sweetsList.add(new SugarCandy(sweetName, sweetProducer, price, weight, lollipop));
			} else {
				System.out.println("Enter name");
				String sweetName = in.nextLine();
				in.nextLine();  // Consume newline left-over
				System.out.println("Enter producer");
				String sweetProducer = in.nextLine();
				System.out.println("Enter price");
				int price = in.nextInt();
				System.out.println("Enter weight");
				int weight = in.nextInt();
				sweetsList.add(new ChocolateCandy(sweetName, sweetProducer, price, weight));
			}
			System.out.println("__The sweet is added.__" + "\n");
			answerContinue = getFinishFlag();
		}
		return sweetsList; // (?)
	}
	
	public boolean getFinishFlag(){
		Scanner in = new Scanner ( System.in );
		System.out.println("Enter \"Y\" if you want to continue. Enter any other key to stop the program"); 
		String answerContinue = in.next();
		if (answerContinue.equalsIgnoreCase("y")){
			return true;
		} else {
				return false;
		}
	}
	
}
