package by.epam.tat.task7.utils;

import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.testng.Assert;
import by.epam.tat.task7.base_test.BaseGiftTest;
import by.epam.tat.task7.objects.Sweets;
import by.epam.tat.task7.utils.exceptions.OpeningSavedCollectionException;

public class FileReaderSaverTest extends BaseGiftTest {

	@Test
	public void getSavedGiftTest() {
		IReaderSaver saver = new FileReaderSaver();
		List<Sweets> sweets = null;
		try {
			sweets = saver.getSavedGift();
		} catch (OpeningSavedCollectionException e) {
			System.out.println(e.getMessage());
		}
		String actualLine = sweets.get(0).toString();
		Assert.assertEquals(actualLine, "Name: sweetName1, Producer: sweetProducer, Price: 1, Weight: 5");
	}

	@Test
	public void saveGiftTest() {
		String actualLine = null;
		addSweetsforTest(1);
		FileReaderSaver saveGiftToFile = new FileReaderSaver();
		saveGiftToFile.saveGift(gift);
		BufferedReader inPutStream = null;
		try {
			inPutStream = new BufferedReader(new FileReader("txt.txt"));
			actualLine = inPutStream.readLine();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		if (inPutStream != null) {
			try {
				inPutStream.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		Assert.assertEquals(actualLine, "Name: sweetName1, Producer: sweetProducer, Price: 1, Weight: 5");
	}

}
