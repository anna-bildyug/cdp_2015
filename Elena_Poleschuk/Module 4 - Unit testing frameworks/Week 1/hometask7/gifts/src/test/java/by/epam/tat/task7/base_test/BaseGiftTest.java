package by.epam.tat.task7.base_test;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.*;

import by.epam.tat.task7.objects.ChocolateCandy;
import by.epam.tat.task7.objects.Gift;
import by.epam.tat.task7.objects.Sweets;
import by.epam.tat.task7.utils.exceptions.ExceedCountSweetsExeption;

public class BaseGiftTest {

	protected Gift gift;

	@BeforeClass
	public void setUp() {
		gift = new Gift();
	}

	@AfterMethod
	public void clearGift() {
		gift.removeAllSweets();
	}

	public List<Sweets> fillCollection(int count) {
		List<Sweets> sweetCollection = new ArrayList<Sweets>();
		for (int i = 1; i <= count; i++) {
			Sweets sweet = new ChocolateCandy("sweetName" + i, "sweetProducer", 1, 5);
			sweetCollection.add(sweet);
		}
		return sweetCollection;
	}

	
	public void addSweetsforTest(int count) {
		List<Sweets> sweetCollection = fillCollection(count);
		for (Sweets sweet : sweetCollection) {
			try {
				gift.addSweet(sweet);
			} catch (ExceedCountSweetsExeption e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
