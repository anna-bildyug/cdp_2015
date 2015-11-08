package present.console;

import java.util.Scanner;

public class InputOutputStreams {
	
	public static void printMessage (String message){//creating method for printing strings out to the console
		System.out.println(message);
	}
	
	public static String scanMessage (){//creating method to get operation from console
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
