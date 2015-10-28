package hometask1.week1.module3.tam;

public class Calculator {
	
	double fNumber = Runner.firstNumber;
	double sNumber = Runner.secondNumber;
	char oper = Runner.operation;
	
	public double performCalculation (double fNumber, double sNumber,char oper){
		
		double result=0;
		
		switch (oper){
		
		case '+':
		result = fNumber + sNumber;
		break;
		
	    case '-':
		result = fNumber - sNumber;
		break;
	
		case '*':
		result = fNumber * sNumber;
		break;
			
		case '/':
			if (sNumber == 0){
				Console.output("It is forbidden to divide by zero!");
				break;
			}
			else{
		       result = fNumber / sNumber;
		       break;
			}
		default:
			Console.output("Please, enter -, +, / or *");
		}
		return result;
		
  }
		
}