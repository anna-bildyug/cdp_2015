package by.epam.tat.lecture2.speed;

import java.util.HashSet;
import java.util.Random;

/**
 * Проверить скорость работы (добавление, поиск элемента, удаление) следующих коллекций:
 * NOTE: Для наглядности рекомендуется использовать от 7000+ элементов в коллекции

 * @author Elena
 *
 */
public class Runner {

	public static void main(String[] args) {
		// Declare a collection
		HashSet<Integer> hashSet = new  HashSet<Integer>();
		//Fill the collection
		for (int i = 0; i < 5; i++){
			Integer d = new Random().nextInt();
			hashSet.add(d);
		}
		// Show the collection
		System.out.println("Collection is: ");
		for (Integer d : hashSet){
			System.out.print(d + " : ");
		}
		System.out.println();
		
		//Add element
		hashSet.add(999);
		
		// Show the collection
		System.out.println("Collection is: ");
		for (Integer d : hashSet){
			System.out.print(d + " : ");
		}
		System.out.println();
		
		// search element
		for (Integer d : hashSet){
			if (hashSet.contains(999)){
				System.out.println("The value is found");
			}else {
				System.out.println("The value is not found");
			}
		}
		
	}

}
