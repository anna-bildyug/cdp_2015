package hometask1.week1.module3.tam;
import java.util.*;

public class Console {
	

	public static void output (String message){//creating method for printing strings out to the console
		System.out.println(message);
	}
	
	public static char inputOperation (){//creating method to get operation from console
		Scanner oper = new Scanner (System.in);
		char operator = oper.next(".").charAt(0);	
		return operator;
	}
	
	public static double inputNumber (){//creating method to get numbers from console
		Scanner in = new Scanner (System.in);
		double numb = in.nextDouble();
		return numb;
		
	}
	
	
	}	

	  

