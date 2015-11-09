package by.epam.cdp.java.collections;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
	
	static Set<Integer> hashSet = new HashSet<>();
	private static Set<Integer> treeSet = new TreeSet<>();
	private static long startTime;
    private static long endTime;

	
	 
    public void  getHashSetAddingSpeed (){
    	startTime = Calendar.getInstance().getTimeInMillis();
        for(int i = 0; i < 100000; i++){
        	hashSet.add(i);
        }
        endTime = Calendar.getInstance().getTimeInMillis();
        long hashSetAddingTime = endTime - startTime;
        System.out.println("Time for adding 100.000 elements to HashSet: " + (hashSetAddingTime) + " ms");       
    }
    
    public void  getTreeSetAddingSpeed (){
    	startTime = Calendar.getInstance().getTimeInMillis();
        for(int i = 0; i < 100000; i++){
        	treeSet.add(i);
        }
        endTime = Calendar.getInstance().getTimeInMillis();
        long treeSetAddingTime = endTime - startTime;
        System.out.println("Time for adding 100.000 elements to TreeSet: " + (treeSetAddingTime) + " ms");       
    }
    
    public void getHashSetFindingSpeed (){
    	startTime = Calendar.getInstance().getTimeInMillis();
    	for (Iterator<Integer> it = hashSet.iterator(); it.hasNext(); ) {
            Integer f = it.next();
            if (f.equals(new Integer(100000))){
            	
            }  	
        }
        endTime = Calendar.getInstance().getTimeInMillis();
        long hashSetFindingTime = endTime - startTime;
    	System.out.println("Time for finding 100.000 element for HashSet " + (hashSetFindingTime) + " ms");
     }
    
    public void getTreeSetFindingSpeed (){
    	startTime = Calendar.getInstance().getTimeInMillis();
    	for (Iterator<Integer> it = treeSet.iterator(); it.hasNext(); ) {
            Integer f = it.next();
            if (f.equals(new Integer(100000))){
            } 	
        }
        endTime = Calendar.getInstance().getTimeInMillis();
        long treeSetFindingTime = endTime - startTime;
    	System.out.println("Time for finding 100.000 element for TreeSet: " + (treeSetFindingTime) + " ms");
    	
     } 
    
    public void getHashSetDeletingSpeed (){
    	startTime = Calendar.getInstance().getTimeInMillis();
    	hashSet.removeAll(hashSet);
    	endTime = Calendar.getInstance().getTimeInMillis();
    	long hashSetDeletingTime = endTime - startTime;
    	System.out.println("Time for deleting 100.000 elements from HashSet: " + (hashSetDeletingTime) + " ms");
    	
    }
    
    public void getTreeSetDeletingSpeed (){
    	startTime = Calendar.getInstance().getTimeInMillis();
    	treeSet.removeAll(treeSet);
    	endTime = Calendar.getInstance().getTimeInMillis();
    	long treeSetDeletingTime = endTime - startTime;
    	System.out.println("Time for deleting 100.000 elements from TreeSet: " + (treeSetDeletingTime) + " ms");
    	
    }
}
