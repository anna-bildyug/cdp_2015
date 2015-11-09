package by.epam.cdp.java.collections;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Lists {
	
	private static List<Integer> arrayList = new ArrayList<>();
	private static List<Integer> linkedList = new LinkedList<>();
	private static long startTime;
    private static long endTime;
    int item = new Random().nextInt(100000); 
    
    public void  getArrayListAddingSpeed (){
    	startTime = Calendar.getInstance().getTimeInMillis();
        for(int i = 0; i < 100000; i++){
        	arrayList.add(i);
        }
        endTime = Calendar.getInstance().getTimeInMillis();
        long arrayListAddingTime = endTime - startTime;
        System.out.println("Time for adding 100.000 elements to ArrayList: " + (arrayListAddingTime) + " ms");       
    }
    
    public void getLinkedListAddingSpeed (){
    	startTime = Calendar.getInstance().getTimeInMillis();
        for(int i = 0; i < 100000; i++){
        	linkedList.add(i);
        }
        endTime = Calendar.getInstance().getTimeInMillis();
        long linkedListAddingTime = endTime - startTime;
        System.out.println("Time for adding 100.000 elements to LinkedList: " + (linkedListAddingTime) + " ms");
    }
    
    public void getArrayListFindingSpeed (){
    	startTime = Calendar.getInstance().getTimeInMillis();
        arrayList.get(item);
        endTime = Calendar.getInstance().getTimeInMillis();
        long arrayListFindingTime = endTime - startTime;
    	System.out.println("Time for finding random element from 100.000 elements for ArrayList: " + (arrayListFindingTime) + " ms");
     }
    
    public void getLinkedListFindingSpeed (){
    	startTime = Calendar.getInstance().getTimeInMillis();
        linkedList.get(item);
        endTime = Calendar.getInstance().getTimeInMillis();
        long arrayListFindingTime = endTime - startTime;
    	System.out.println("Time for finding random element from 100.000 elements for LinkedList: " + (arrayListFindingTime) + " ms");
     }
    
    public void getArrayListDeletingSpeed (){
    	startTime = Calendar.getInstance().getTimeInMillis();
    	arrayList.removeAll(arrayList);
    	endTime = Calendar.getInstance().getTimeInMillis();
    	long arrayListDeletingTime = endTime - startTime;
    	System.out.println("Time for deleting 100.000 elements from ArrayList: " + (arrayListDeletingTime) + " ms");
    	
    }
    
    public void getLinkedListDeletingSpeed (){
    	startTime = Calendar.getInstance().getTimeInMillis();
    	linkedList.removeAll(linkedList);
    	endTime = Calendar.getInstance().getTimeInMillis();
    	long linkedListDeletingTime = endTime - startTime;
    	System.out.println("Time for deleting 100.000 elements from LinkedList: " + (linkedListDeletingTime) + " ms");
    }
   
    
}
