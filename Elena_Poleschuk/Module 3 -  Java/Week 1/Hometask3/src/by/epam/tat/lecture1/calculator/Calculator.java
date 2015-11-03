package by.epam.tat.lecture1.calculator;

public class Calculator {
	
	public int calculate (int value, String action, int result) {
			try{
				switch (action)
					{
						case "+":
							result = result + value;
							break;
						case "-":
							result = result - value; 
							break;			
						case "*":
							result = result * value; 
							break;	
						case "/":
							result = result / value;
							break;		
						default:
							System.out.print("Result: " + result);
					}
				}
				catch (ArithmeticException exc){
					System.out.println("Can't divide by Zero! Use another value");
			}	
		return result;
	}
}
