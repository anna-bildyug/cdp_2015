package by.epam.tat.lecture1.calculator;
import java.util.Scanner;

public class Calculator {
	int value;
	String action;
	public Scanner in = new Scanner ( System.in );
	
	
	public int getValue(){
		
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
		return value;
	}
	
	public String getAction(){
		System.out.println("Enter a action: * / + - ="); 
		action = in.next();
		return action;		
	}
	
	public boolean repeatQuestion(){
		System.out.println("Do you want to continue? Enter Y. Any other entering value results in stopping the program"); 
		String answer = in.next();
		if (answer.equalsIgnoreCase("y")){
			return true;
		} else {
				return false;
		}
	}
	
	public void calculation() {
		int result;
		System.out.println("Calculator works with integer digits and simple actions: -, +, /, *.");
		do {
			result = getValue();
			getAction();
			while ( action.equals("=") == false){
			try{
				switch (action)
					{
						case "+":
							result = (result + getValue());
							break;
						case "-":
							result = result - getValue(); 
							break;			
						case "*":
							result = result * getValue(); 
							break;	
						case "/":
							result = result / getValue();
							break;		
						default:
							System.out.print("Error: action is incorrect. ");
					}
				}
				catch (ArithmeticException exc){
					System.out.println("Can't divide by Zero! Use another value");
					continue;
				}
				getAction();
			}	
			System.out.println("Result: " + result);
		}
		while ((repeatQuestion() == true));
		System.out.println("The program is stopped");
	}
	
	public static void main (String[] arg) {
		Calculator calculator = new Calculator();
		calculator.calculation();		
		

	}
}
