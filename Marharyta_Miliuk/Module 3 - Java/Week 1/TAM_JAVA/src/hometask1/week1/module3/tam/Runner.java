package hometask1.week1.module3.tam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import hometask2.week1.module3.tam.Strings;

public class Runner {
		
	public static double firstNumber;//defining fields for first and second numbers, operation (for calculator only!)
	public static double secondNumber;
	public static char  operation;

	public static void main (String [] args) throws IOException{
		
	   /*try{
		Console.output("Please, enter first number");
		firstNumber = Console.inputNumber();//getting first number using method from Console class
		Console.output("Please, enter second number");
		secondNumber = Console.inputNumber();//getting second number using method from Console class
		Console.output("Please, enter operation");
		operation  = Console.inputOperation();//getting operation using method from Console class
		Calculator calculator = new Calculator();
		Console.output("The result is: " + calculator.performCalculation(firstNumber, secondNumber, operation));//starting execution of method from Calculator class using values from console
	    }
	    
		catch (InputMismatchException e){//catching exception that occurs when user types values with wrong type
			Console.output("Wrong type! Please, enter number");
		
		}
		
	}*/
		try {	
		Strings strings = new Strings();
		String[] massiveStrings = strings.establishMassive();//setting variable for value returned from establishMassive method
		massiveStrings = strings.sortStrings(massiveStrings);//setting return value as a result of sortStrings method
		strings.printSortedStrings(massiveStrings);//printing sorted strings that were returned from sortStrings method
		}
		catch (InputMismatchException e) {//catching exception that occurs when user types values with wrong type
			System.out.println("You should enter a number! Try again");
		}
		catch (NegativeArraySizeException e){//catching exception that occurs when user is trying to set a negative value
			System.out.println("You should enter a positive number only! Try again");
		}
		
	}		
}


	 
	    			
		
	


	
	
	

