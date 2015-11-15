package by.epam.tat.lecture2.task1.utils.comparators;

import java.util.Comparator;

import by.epam.tat.lecture2.task1.objects.Sweets;

public class NameComparator implements Comparator<Sweets>{
	public int compare(Sweets o1, Sweets o2){
		String name1 = o1.getSweetName();
		String name2 = o2.getSweetName();
		return name1.compareTo(name2);
	}

}
