package by.epam.tat.lecture1.calculator;

public class Runner {
	public static void main (String[] arg) {
		Calculator calculator = new Calculator();
		Communicator flagStop = new Communicator();
		
		int temp = 0, value, result;
		boolean stop;
		String action;
		System.out.println("Calculator works with integer digits and simple actions: -, +, /, *. Enter \"=\" to get result");

		do {
			temp = Communicator.getValue();
			action = Communicator.getAction();
			while (!action.equals("="))
			{
				value = Communicator.getValue();
				result = calculator.calculate(value, action, temp);
				temp = result;
				action = Communicator.getAction();
			};
			System.out.println("result is " + temp);
			stop = flagStop.getFinishFlag();
		}
		while (stop);	
		System.out.println("Program is stopped");	
	}	
}
