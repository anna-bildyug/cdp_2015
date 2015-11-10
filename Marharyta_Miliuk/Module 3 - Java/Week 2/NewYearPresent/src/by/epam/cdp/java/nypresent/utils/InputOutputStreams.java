package by.epam.cdp.java.nypresent.utils;

import java.util.List;
import java.util.Scanner;

import by.epam.cdp.java.nypresent.beans.Sweets;

public class InputOutputStreams {
	
	public static void printMessage (String message){//creating methods for printing strings out to the console
		System.out.println(message);
		System.out.close();
	}
	
	public static void printCollection (List<Sweets> collection){
		System.out.println(collection);
		System.out.close();
	}
	
	public static void printObject (Sweets object){
		System.out.println(object);
		System.out.close();
	}
	
	public static String scanMessage (){//creating methods to get input from console
		Scanner in = new Scanner (System.in);
		String message = in.nextLine();	
		in.close();
		return message;
		
	}
	public static int scanNumbers (){
		 Scanner in = new Scanner (System.in);
		 int number = in.nextInt();
		 in.close();
		 return number;
	 }

}