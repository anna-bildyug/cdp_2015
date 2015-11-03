package by.epam.tat.lecture2.speed;

import java.util.HashSet;
import java.util.Random;

public class Lists {
// 2.	Sets (HashSet vs TreeSet);
	public void createHashSet(){
		HashSet<Integer> hashSet = new  HashSet<Integer>();
		for (int i = 0; i < 10; i++){
			Integer d = new Random().nextInt();
			hashSet.add(d);
		}
	}
	
	
	
	
	
	
}
