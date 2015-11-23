package by.epam.cdp.java.nypresent.utils;

import java.util.List;
import java.util.Scanner;

import by.epam.cdp.java.nypresent.beans.Sweets;

public class PrinterScanner {
	
	public static void printCollection (List<Sweets> collection){
		for (Sweets sweet : collection){
		System.out.println(sweet);
		}
	}
	
	public static void printObject (Object object){
		System.out.println(object);
	}
	
	public static String scanMessage (){//creating methods to get input from console
		Scanner in = new Scanner (System.in);
		String message = in.nextLine();	
		return message;
		
	}
	public static int scanNumbers (){
		 Scanner in = new Scanner (System.in);
		 int number = in.nextInt();
		 return number;
	 }

	
}