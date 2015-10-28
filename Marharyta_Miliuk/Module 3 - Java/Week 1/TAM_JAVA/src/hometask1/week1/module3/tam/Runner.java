package hometask1.week1.module3.tam;
import java.util.*;

public class Runner {
		
	public static double firstNumber;
	public static double secondNumber;
	public static char  operation;

	public static void main (String [] args){
	
	    try{
		Console.output("Please, enter first number");
		Console.inputNumber(firstNumber);
		Console.output("Please, enter second number");
		Console.inputNumber(secondNumber);
		Console.output("Please, enter operation");
		Console.inputOperation(operation);
		Calculator calculator = new Calculator();
		Console.output("The result is: " + calculator.performCalculation(firstNumber, secondNumber, operation));
	    }
	    catch (ArithmeticException e){
			Console.output("It's forbidden to divide by zero!");
			Calculator calculator = new Calculator();
			calculator.performCalculation(firstNumber, secondNumber, operation);
			
		}
		catch (InputMismatchException e){
			Console.output("Please, enter number");
			Calculator calculator = new Calculator();
			calculator.performCalculation(firstNumber, secondNumber, operation);
			
		
		}

	}
		}



		
	
	

