package by.epam.tat.lecture1.calculator;

public class Calculator {
	
	public void calculation() {
		int result;
		String action;
		System.out.println("Calculator works with integer digits and simple actions: -, +, /, *.");
		do {
			result = Communicator.getValue();
		//	Communicator.in.nextLine();  // Consume newline left-over
			action = Communicator.getAction();
			System.out.println(action);
			while ( action.equals("=") != true){
			try{
				switch (action)
					{
						case "+":
							result = (result + Communicator.getValue());
							break;
						case "-":
							result = result - Communicator.getValue(); 
							break;			
						case "*":
							result = result * Communicator.getValue(); 
							break;	
						case "/":
							result = result / Communicator.getValue();
							break;		
						default:
							System.out.print("Error: action is incorrect. ");
					}
				}
				catch (ArithmeticException exc){
					System.out.println("Can't divide by Zero! Use another value");
					continue;
				}
			action = Communicator.getAction();
			System.out.println(action);
			}	
			System.out.println("Result: " + result);
		}
		while ((Communicator.repeatQuestion() == true));
		System.out.println("The program is stopped");
	}
}
