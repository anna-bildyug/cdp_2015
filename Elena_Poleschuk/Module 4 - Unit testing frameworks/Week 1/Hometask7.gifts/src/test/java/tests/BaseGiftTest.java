package tests;

import org.testng.annotations.*;

import by.epam.tat.lecture2.task1.objects.Gift;


public class BaseGiftTest {

	protected Gift gift;

    @BeforeClass							
    public void setUp(){
        gift = new Gift();
    }
    

    @AfterMethod						
    public void clearGift(){
    	gift.removeAllSweets();
    }
    
	

}
