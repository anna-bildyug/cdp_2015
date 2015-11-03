package hometask1.week1.module3.tam;
import java.util.*;

public class Console {
	

<<<<<<< HEAD
	public static void output (String message){
		System.out.println(message);
	}
	
	public static char inputOperation (char operation){
=======
	public static void output (String message){//creating method for printing strings out to the console
		System.out.println(message);
	}
	
	public static char inputOperation (){//creating method to get operation from console
>>>>>>> 720ca4ceaf0148e96c9fb2350f82317d60239ef7
		Scanner oper = new Scanner (System.in);
		char operator = oper.next(".").charAt(0);	
		return operator;
	}
	
<<<<<<< HEAD
	public static double inputNumber (double Number){
=======
	public static double inputNumber (){//creating method to get numbers from console
>>>>>>> 720ca4ceaf0148e96c9fb2350f82317d60239ef7
		Scanner in = new Scanner (System.in);
		double numb = in.nextDouble();
		return numb;
		
	}
	
	
	}	

	  

