package List;

import java.util.*;

/**	
 * Sort list or array by string length 
 * (Отсортировать список по длине строк)
 * @author Elena
 *
 */
public class List {
	 
	
	public static void main (String[] arg){
		Scanner in = new Scanner (System.in);
		System.out.println("How many strings do you want to create?");
		// !может быть ошибка! введение не int или 0
		int nString = in.nextInt();
		in.nextLine();  // Consume newline left-over
		String[] masStrings = new String[nString]; 
		for (int n = 0; n < nString; n++){
			System.out.println("Enter " + (n + 1) + " srting");
			masStrings[n] = in.nextLine();	
		}	
		//Sort list or array by string length 
		for (int x = 0; x < masStrings.length - 1; x++){
			for (int n = masStrings.length-1; n > 0 ; n--){
				if (masStrings[n].length() < masStrings[n-1].length()){
					String temp = masStrings[n];
					masStrings[n] = masStrings[n-1];
					masStrings[n-1] = temp;
				}
			}	
		}
		// print sorted list
		for (int n = 0; n < masStrings.length; n++){
			System.out.println(masStrings[n]);
		}
	}
}
