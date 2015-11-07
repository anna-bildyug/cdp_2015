package by.epam.tat.lecture2.task1.utils;

import java.util.Scanner;

public class Communicator {
	
	public static boolean getFlag(){
		Scanner in = new Scanner ( System.in );
		String answerContinue = in.next();
		if (answerContinue.equalsIgnoreCase("y")){
			return true;
		} else {
				return false;
		}
	}
		
	public static int intScanner(){
		Scanner in = new Scanner(System.in);
		int intValue = 0;
		boolean a = true;
		while (a){
			try{
				intValue = in.nextInt();
				a = false;
			}
			catch (Throwable exc){
				System.out.println("Error: only Integer can be used");
				in.nextLine();  // Consume newline left-over
			}
		}
		return intValue;
	}	
	
	public static String stringScanner(){
		Scanner in = new Scanner(System.in);
		String stringValue = in.nextLine();
		return stringValue;
	}	
	
	public static void out(String textPrint){
		System.out.println(textPrint);
	}
	
	}
	
	
