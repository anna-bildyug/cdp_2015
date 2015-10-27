package hometask1.week1.module3.tam;

public class Calculator {
	
	static int calculate (int firstNumber, int secondNumber, String operation){
		
		int result;
		switch (operation){
		
		case "+":
		result = firstNumber + secondNumber;
		return result;
		
		case "-":
		result = firstNumber - secondNumber;
		return result;
	
		case "*":
		result = firstNumber * secondNumber;
		return result;
			
		case "/":
		result = firstNumber / secondNumber;
		return result;
				
		default:
			result = 0;//initializing default value for the alternative scenario to handle
			return result;
					
	}		
  }
}