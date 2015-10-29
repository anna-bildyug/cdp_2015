package hometask1.week1.module3.tam;

public class Calculator {
	
	double fNumber = Runner.firstNumber;//setting fields from Runner class
	double sNumber = Runner.secondNumber;
	char oper = Runner.operation;
	
	public double performCalculation (double fNumber, double sNumber,char oper){//creating method using fields with data from Runner class
		
		double result=0;
		
		switch (oper){//handling all possible operations 
		
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
			if (sNumber == 0){//handling case with dividing by zero
				Console.output("It is forbidden to divide by zero!");
				break;
			}
			else{
		       result = fNumber / sNumber;
		       break;
			}
		default:
			Console.output("Please, enter -, +, / or *");//handling case when user types not one of the 4 operations
		}
		return result;
		
  }
		
}