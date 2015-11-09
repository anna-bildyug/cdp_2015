package by.epam.cdp.java.collections;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Maps {
	private static Map<Integer, Integer> hashMap = new HashMap<>();
	private static Map<Integer, Integer> treeMap = new TreeMap<>();
	private static long startTime;
    private static long endTime;
    int item = new Random().nextInt(100000); 

    
    public void  getHashMapAddingSpeed (){
    	int key = new Random().nextInt();
    	int value  = new Random().nextInt();
    	startTime = Calendar.getInstance().getTimeInMillis();
        for(int i = 0; i < 100000; i++){
        	hashMap.put(key, value);
        }
        endTime = Calendar.getInstance().getTimeInMillis();
        long hashMapAddingTime = endTime - startTime;
        System.out.println("Time for adding 100.000 elements to HashMap: " + (hashMapAddingTime) + " ms");       
    }
    
    public void  getTreeMapAddingSpeed (){
    	int key = new Random().nextInt();
    	int value  = new Random().nextInt();
    	startTime = Calendar.getInstance().getTimeInMillis();
        for(int i = 0; i < 100000; i++){
        	treeMap.put(key, value);
        }
        endTime = Calendar.getInstance().getTimeInMillis();
        long treeMapAddingTime = endTime - startTime;
        System.out.println("Time for adding 100.000 elements to TreeMap: " + (treeMapAddingTime) + " ms");       
    }
    
    public void getHashMapFindingSpeed (){
    	startTime = Calendar.getInstance().getTimeInMillis();
        hashMap.get(item);
        endTime = Calendar.getInstance().getTimeInMillis();
        long hashMapFindingTime = endTime - startTime;
    	   System.out.println("Time for finding random element from 100.000 elements for HashMap: " + (hashMapFindingTime) + " ms");
     }
    
    public void getTreeMapFindingSpeed (){
    	startTime = Calendar.getInstance().getTimeInMillis();
        treeMap.get(item);
        endTime = Calendar.getInstance().getTimeInMillis();
        long treeMapFindingTime = endTime - startTime;
    	   System.out.println("Time for finding random element from 100.000 elements for TreeMap: " + (treeMapFindingTime) + " ms");
     }
    
    public void getHashMapDeletingSpeed (){
    	startTime = Calendar.getInstance().getTimeInMillis();
        hashMap.clear();
    	endTime = Calendar.getInstance().getTimeInMillis();
    	long HashMapDeletingTime = endTime - startTime;
    	System.out.println("Time for deleting 100.000 elements from HashMap: " + (HashMapDeletingTime) + " ms");
    	
    }
    
    public void getTreeMapDeletingSpeed (){
    	startTime = Calendar.getInstance().getTimeInMillis();
        treeMap.clear();
    	endTime = Calendar.getInstance().getTimeInMillis();
    	long treeMapDeletingTime = endTime - startTime;
    	System.out.println("Time for deleting 100.000 elements from TreeMap: " + (treeMapDeletingTime) + " ms");
    	
    }
}
