package Calculator;
import java.util.Scanner;

public class Calculator {
	Scanner in = new Scanner ( System.in );	
	
	void Calculation() {
		
		System.out.println("Enter first value");
		int a = in.nextInt();	
		System.out.println("Enter action: * / - +");
		String act = in.next();
		System.out.println("Enter second value");
		int b = in.nextInt();
		int result = 0;
		switch (act)
		{
			case "+":
				result = (a + b) ;
				break;
			case "-":
				result = a - b ;
				break;			
			case "*":
				result = a * b ;
				break;	
			case "/":
				result = a / b ;
				break;		
			default:
				System.out.println("error: action was incorrect");
		}
		System.out.println("Result: " + result);
	}
	
	public static void main (String[] arg) {
		Calculator startCalc = new Calculator();
		startCalc.Calculation();		

	}
}
