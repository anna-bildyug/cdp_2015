package hometask1.week1.module3.tam;
import java.util.*;

public class Runner {
	public static void main (String [] args){
		
	boolean yesOrNo = true;	//setting the boolean variable to get nd use value from userConfirmation method
	
	do {	
		try{
		InputOutput.communication();
		yesOrNo = InputOutput.userConfirmation();
		}
		catch (ArithmeticException e){//catching exception, when user is trying to divide by zero
			InputOutput.nullExceptionMessage();
			InputOutput.communication();
		}
		catch (InputMismatchException e){//catching exception, when user is trying to enter the value with invalid type
			InputOutput.inputExceptionMessage();
			InputOutput.communication();				
	}
}
	while (yesOrNo == true);//program runs in case user confirmed rerun
		
	}
		}



		
	
	

