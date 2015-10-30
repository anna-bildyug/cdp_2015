package by.epam.tat.lecture1.calculator;
import java.util.Scanner;

public class Communicator {
	
	public static int getValue(){
		Scanner in = new Scanner ( System.in );
		int value;
		while(true) {
			try{
				System.out.println("Enter a value");
				value = in.nextInt();
				break;
				}
			catch (Throwable exc){
				System.out.print("Incorrect value is entered. Try again. ");
				in.nextLine();  // Consume newline left-over
				}; 
		}	
		in.nextLine();  // Consume newline left-over
		return value;
	}
	
	public static String getAction(){
		String action;
		do {
			Scanner in = new Scanner ( System.in );
			System.out.println("Enter a action: * / + - =");
			action = in.nextLine();
			if (action.equals("+") || action.equals("-") || action.equals("*") || action.equals("/") || action.equals("=")){
				break;
			} else {
				System.out.print("Error: action is incorrect. ");
			}
		}
		while (true);
		return action;
	}
	
	public boolean getFinishFlag(){
		Scanner in = new Scanner ( System.in );
		System.out.println("Enter \"Y\" if you want to continue. Enter any other key to stop the program"); 
		String answer = in.next();
		if (answer.equalsIgnoreCase("y")){
			return true;
		} else {
				return false;
		}
	}
}
