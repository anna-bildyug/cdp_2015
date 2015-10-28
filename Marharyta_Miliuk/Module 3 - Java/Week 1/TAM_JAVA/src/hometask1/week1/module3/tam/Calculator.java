package hometask1.week1.module3.tam;

public class Calculator {
	
	double fNumber = Runner.firstNumber;
	double sNumber = Runner.secondNumber;
	char oper = Runner.operation;
	
	public double performCalculation (double fNumber, double sNumber,char oper){
		
		double result;
		
		switch (this.oper){
		
		case '+':
		result = this.fNumber + this.sNumber;
		break;
		
	    case '-':
		result = this.fNumber - this.sNumber;
		return result;
	
		case '*':
		result = this.fNumber * this.sNumber;
		return result;
			
		case '/':
		result = this.fNumber / this.sNumber;
		return result;
		
		default:
			result = 0;
			Console.output("Please, enter -, +, / or *");
			return result;	
		}
		return result;
		
  }
		
}