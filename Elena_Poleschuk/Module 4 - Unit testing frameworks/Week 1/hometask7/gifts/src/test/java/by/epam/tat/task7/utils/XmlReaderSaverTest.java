package by.epam.tat.task7.utils;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import by.epam.tat.task7.base_test.BaseGiftTest;
import by.epam.tat.task7.objects.Sweets;
import by.epam.tat.task7.utils.exceptions.OpeningSavedCollectionException;

public class XmlReaderSaverTest extends BaseGiftTest {

	@Test
	public void getSavedGiftTest() {
		IReaderSaver saver = new XmlReaderSaver();
		List<Sweets> sweets = null;
		try {
			sweets = saver.getSavedGift();
		} catch (OpeningSavedCollectionException e) {
			System.out.println(e.getMessage());
		}
		String actualSweets = sweets.get(0).toString();
		Assert.assertEquals(actualSweets, "Name: sweetName1, Producer: sweetProducer, Price: 1, Weight: 5");
	}
}
