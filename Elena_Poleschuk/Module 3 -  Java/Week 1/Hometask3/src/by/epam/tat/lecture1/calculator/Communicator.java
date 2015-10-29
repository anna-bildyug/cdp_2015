package by.epam.tat.lecture1.calculator;
import java.util.Scanner;

public class Communicator {
	static int value;
	static String action;
	public static Scanner in = new Scanner ( System.in );
	
	public static int getValue(){
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
		System.out.println("Enter a action: * / + - ="); 
		action = in.nextLine();
		return action;		
	}
	
	public static boolean repeatQuestion(){
		System.out.println("Enter Y if you want to continue. Any other entering results in stopping the program"); 
		String answer = in.next();
		if (answer.equalsIgnoreCase("y")){
			return true;
		} else {
				return false;
		}
	}
}
