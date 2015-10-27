package by.epam.tat.lecture1.list;

import java.util.*;

/**	
 * Sort list or array by string length 
 *
 * @author Elena
 *
 */
public class List {
	
	public void createList(){
		Scanner in = new Scanner (System.in);
		System.out.println("How many strings do you want to create?");
		int nString = in.nextInt();
		in.nextLine();  // Consume newline left-over
		String[] masStrings = new String[nString]; 
		for (int n = 0; n < nString; n++){
			System.out.println("Enter " + (n + 1) + " srting");
			masStrings[n] = in.nextLine();	
		}	
		System.out.println("The List is created");
		System.out.println("-----------------");
		in.close();
		printList(masStrings);
		sorting(masStrings);
	}	
		
	public void sorting(String[] list){
		for (int x = 0; x < list.length - 1; x++){
			for (int n = list.length-1; n > 0 ; n--){
				if (list[n].length() < list[n-1].length()){
					String temp = list[n];
					list[n] = list[n-1];
					list[n-1] = temp;
				}
			}	
		}
		System.out.println("The List is sorted");
		System.out.println("-----------------");
		printList(list);
	}	

	public void printList(String[] list){
		for (int n = 0; n < list.length; n++){
			System.out.println(list[n]);
		}			
	}
	
	
	public static void main (String[] arg){
		List sortingList = new List();
		sortingList.createList();
	}
}
