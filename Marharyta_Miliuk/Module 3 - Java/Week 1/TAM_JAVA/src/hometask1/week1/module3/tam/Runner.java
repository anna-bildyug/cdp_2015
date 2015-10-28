package hometask1.week1.module3.tam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Runner {
		
	public static double firstNumber;
	public static double secondNumber;
	public static char  operation;

	public static void main (String [] args) {
	   
	   try{
		Console.output("Please, enter first number");
		firstNumber = Console.inputNumber();
		Console.output("Please, enter second number");
		secondNumber = Console.inputNumber();
		Console.output("Please, enter operation");
		operation  = Console.inputOperation();
		Calculator calculator = new Calculator();
		Console.output("The result is: " + calculator.performCalculation(firstNumber, secondNumber, operation));
	    }
	    
		catch (InputMismatchException e){
			Console.output("Wrong type! Please, enter number");
		
		}
	}
}



		
	
	

