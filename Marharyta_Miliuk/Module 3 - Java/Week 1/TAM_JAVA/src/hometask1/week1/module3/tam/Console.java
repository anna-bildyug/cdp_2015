package hometask1.week1.module3.tam;
import java.util.*;

public class Console {
	

	public static void output (String message){
		System.out.println(message);
	}
	
	public static char inputOperation (char operation){
		Scanner oper = new Scanner (System.in);
		char operator = oper.next(".").charAt(0);	
		return operator;
	}
	
	public static double inputNumber (double Number){
		Scanner in = new Scanner (System.in);
		double numb = in.nextDouble();
		return numb;
		
	}
	
	
	}	

	  

