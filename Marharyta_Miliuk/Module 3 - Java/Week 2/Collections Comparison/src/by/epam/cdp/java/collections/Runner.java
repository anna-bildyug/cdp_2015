package by.epam.cdp.java.collections;

import java.util.Scanner;

public class Runner {
	public static void main (String [] args){
		
		System.out.println("What collections do you want to compare? (List, Set or Map)");
		Scanner in = new Scanner (System.in);
		String Collection = in.nextLine();
		
		switch (Collection){
		
		case "List":
			Lists list = new Lists();
			list.getArrayListAddingSpeed();
			list.getLinkedListAddingSpeed();
			list.getArrayListFindingSpeed();
			list.getLinkedListFindingSpeed();
			list.getArrayListDeletingSpeed();
			list.getLinkedListDeletingSpeed();
			break;
		
		case "Set":
			Sets set = new Sets();
			set.getHashSetAddingSpeed();
			set.getTreeSetAddingSpeed();
			set.getHashSetFindingSpeed();
			set.getTreeSetFindingSpeed();
			set.getHashSetDeletingSpeed();
			set.getTreeSetDeletingSpeed();
			break;
		
		case "Map":
			Maps map = new Maps();
			map.getHashMapAddingSpeed();
			map.getTreeMapAddingSpeed();
			map.getHashMapFindingSpeed();
			map.getTreeMapFindingSpeed();
			map.getTreeMapDeletingSpeed();
			map.getHashMapDeletingSpeed();
			break;
		
		default:
			System.out.println("Wrong name of collection! You should enter List, Map or Set. Try again!");
		}	
	}

}
