package by.epam.tat.lecture1.list;

import java.util.*;

/**	
 * Sort list or array by string length 
 *
 * @author Elena
 *
 */
public class List {
	
	public static String[] createList(){
		Scanner in = new Scanner (System.in);
		System.out.println("How many strings do you want to create?");
		int nString = in.nextInt();
		in.nextLine();  // Consume newline left-over
		String[] masStrings = new String[nString]; 
		for (int n = 0; n < nString; n++){
			System.out.println("Enter " + (n + 1) + " srting");
			masStrings[n] = in.nextLine();	
		}	
		System.out.println("The List is created:");
		System.out.println("-----------------");
		System.out.println();
		in.close();
		return masStrings;
	}	
		
	
	public static String[]  sortList(String[] list){
		for (int x = 0; x < list.length - 1; x++){
			for (int n = list.length-1; n > 0 ; n--){
				if (list[n].length() < list[n-1].length()){
					String temp = list[n];
					list[n] = list[n-1];
					list[n-1] = temp;
				}
			}	
		}
		return list;
	}	

	public static void printList(String[] list){
		for (int n = 0; n < list.length; n++){
			System.out.println(list[n]);
		}			
	}
	
	public static void main (String[] arg){
		String masStringsInitial[] = createList();
		System.out.println("Initial List:");
		printList(masStringsInitial);
		
		String masStringsSorted[] = sortList(masStringsInitial);
		System.out.println();
		System.out.println("Sorted list:");
		printList(masStringsSorted);
	}
}
