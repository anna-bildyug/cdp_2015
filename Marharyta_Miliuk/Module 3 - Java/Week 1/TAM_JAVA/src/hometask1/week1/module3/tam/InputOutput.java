package hometask1.week1.module3.tam;
import java.util.*;

public class InputOutput {
	
	private static String firstMessage = "Please, enter first number";
	private static String secondMessage = "Please, enter second number";
	private static String thirdMessage = "Please, enter operation";
	private static String fourthMessage = "The result is: ";

	
	static void communication (){
		
		Scanner in = new Scanner (System.in);
		
		System.out.println(firstMessage);
		int firstNumber = in.nextInt();
		
		System.out.println(secondMessage);
		int secondNumber = in.nextInt();
		
		System.out.println(thirdMessage);
		Scanner oper = new Scanner (System.in);
		String operation = oper.nextLine();
		
		int variable = Calculator.calculate(firstNumber, secondNumber, operation);// defining variable for method for comfortable using
		
		if (variable == 0){//if there are an alternative case, where user types not what we're looking for,
			System.out.println("Wrong operation! Please type +, -, * or /");// we show this message
			InputOutput.communication();// and start asking for values again
		}
		
		else {
			System.out.println(fourthMessage  + variable);
		}	
	}
	
	static void nullExceptionMessage (){//method for showing error message in case of arithmetic exception
		System.out.println("Dividing by zero is forbidden! Try again.");
	}
	
	static void inputExceptionMessage (){//method for showing error message in case of input mismatch exception
		System.out.println("Please, enter number.");
	}
	
	static boolean userConfirmation (){
		System.out.println("Do you want to count anything else? Please, enter yes or no");
		Scanner confirm = new Scanner (System.in);
		String userConfirm = confirm.nextLine();
		switch (userConfirm){//handling user answers
		case "yes":
			return true;// in case user is agree, we are starting the rerun
			
		default:
			return false;// in case user is not agree or typing anything except "yes", the program will be terminated
		}	
	}	
}
	  

