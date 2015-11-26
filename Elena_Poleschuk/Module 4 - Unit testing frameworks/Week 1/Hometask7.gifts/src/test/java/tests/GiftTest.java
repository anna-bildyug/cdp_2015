package tests;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import by.epam.tat.lecture2.task1.objects.SugarCandy;
import by.epam.tat.lecture2.task1.objects.Sweets;
import by.epam.tat.lecture2.task1.utils.exceptions.EmptyCollectionException;
import by.epam.tat.lecture2.task1.utils.exceptions.ExceedCountSweetsExeption;

public class GiftTest extends BaseGiftTest {
	
	
	@Test
	public void addSweetTest(){
		Sweets sweet = new SugarCandy("sweetName", "sweetProducer", 1, 5, true, "flavour");
		try {
			gift.addSweet(sweet);
		} catch (ExceedCountSweetsExeption e) {
			System.out.println(e.getMessage());
		}
		Assert.assertEquals(gift.getGiftSize(), 1, "Object is not added");
	}
	
  
	@Test(expectedExceptions = ExceedCountSweetsExeption.class)
	public void add11SweetTest() throws ExceedCountSweetsExeption{
		List<Sweets> sweetCollection = fillCollection(11);
			for(Sweets sweet : sweetCollection){
				gift.addSweet(sweet);
			}
	}
	
	@Test(dependsOnMethods = "addSweetTest")
	public void removeSweetTest() throws EmptyCollectionException{
		addSweetsforTest(10);
		gift.removeSweet("sweetName3"); 
		Assert.assertEquals(gift.getGiftSize(), 9, "Object is not deleted");	//or via find? or?
	}
		
	@Test(expectedExceptions = EmptyCollectionException.class)
	public void removeSweetEmptyGiftTest() throws EmptyCollectionException{
		gift.removeSweet("any"); 
	}
	
	
	@Test(dependsOnMethods = "addSweetTest")
	public void getSumWeightTest() throws EmptyCollectionException{
		addSweetsforTest(10);
		Assert.assertEquals(gift.getSumWeight(), 50, "Invalid result of operation");
	}
	
	@Test(expectedExceptions = EmptyCollectionException.class)
	public void getSumWeightEmptyGiftTest() throws EmptyCollectionException, ExceedCountSweetsExeption{
		gift.getSumWeight();
	}	
	
	@Test(dependsOnMethods = "addSweetTest")
	public void findSweetByExistedNameTest(){
		addSweetsforTest(10);
		boolean nameExist = gift.findSweetByName("sweetName3");
		Assert.assertEquals(nameExist, true, "Sweet is not found");
	}
	
	@Test(dependsOnMethods = "addSweetTest")
	public void findSweetByNotExistedNameTest(){
		addSweetsforTest(10);
		boolean nameExist = gift.findSweetByName("sweetName13");
		Assert.assertEquals(nameExist, false, "Sweet is not found");
	}
	
	public List<Sweets> fillCollection(int count){
		List<Sweets> sweetCollection = new ArrayList<Sweets>();
		for(int i=1; i<=count; i++){
			Sweets sweet = new SugarCandy("sweetName" + i, "sweetProducer", 1, 5, true, "flavour");
			sweetCollection.add(sweet);
		}
		return sweetCollection;
	}
	
	public void addSweetsforTest(int count){
		List<Sweets> sweetCollection = fillCollection(count);
		for(Sweets sweet : sweetCollection){
			try {
				gift.addSweet(sweet);
			} catch (ExceedCountSweetsExeption e) {
				System.out.println(e.getMessage());
			}
		}
	}

}




