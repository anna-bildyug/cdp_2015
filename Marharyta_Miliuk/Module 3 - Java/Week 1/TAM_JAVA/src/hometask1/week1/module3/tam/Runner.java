package hometask1.week1.module3.tam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Runner {
		
	public static double firstNumber;//defining fields for first and second numbers, operation
	public static double secondNumber;
	public static char  operation;

	public static void main (String [] args) {
	   
	   try{
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
	}
}



		
	
	

