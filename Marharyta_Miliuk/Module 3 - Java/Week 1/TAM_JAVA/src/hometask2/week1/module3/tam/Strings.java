package hometask2.week1.module3.tam;

import java.io.*;
import java.util.Scanner;

public class Strings {
	
public int numberOfRows (){//creating a method to set how many strings there will be in a massive
	System.out.println ("How many strings do you need to sort?");
	Scanner in = new Scanner (System.in);
	int number = in.nextInt();
	return number;
}
	
public String[] establishMassive () throws IOException {//creating a method to set values to the massive
	String [] massive = new String [this.numberOfRows()];//creating a massive with number of elements that were established by user in the numberOfRows method
	for (int i = 0; i < massive.length; i++){//we are asking for new string till the number of elements is equal to number that is set in the numberOfRows method
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Please, enter " + (i+1) + " string: ");
    massive[i] = in.readLine();
	}
	return massive;
}

public String [] sortStrings (String [] massive){//creating method for sorting strings
		for (int i=0; i < massive.length; i++ ){// here's the bubble sort is used
		for (int j=i+1; j < massive.length; j++){
			if (massive[j].length() < massive[i].length()){
				String t = massive[j];
				massive[j] = massive[i];
				massive [i] = t;
			}
		}
	}
		return massive;
}
public void printSortedStrings (String [] massive){//creating method for printing sorted strings
	System.out.println("Here's your sorted strings!");
	   for (int n = 0; n < massive.length; n++){
	    	System.out.println(massive[n]);	
	   		}
      }
}