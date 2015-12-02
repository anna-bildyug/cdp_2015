package by.epam.cdp.java.moduletesting;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import epam.cdp.javabasics_testng.L2.Calculator;

public class MemoryTests {
	
	 private double number;
	 
	 @Factory(dataProvider = "dataProvider")
	   public MemoryTests (double number){
		  this.number = number;	
	  }
	 
	  @DataProvider
	  public static Object [][] dataProvider(){		  
		  return new Object [][] {{1}};	 		  
	  }

	  @Test (groups = "Memory tests")
	  public void testSetGetFromMemory(){
		  Calculator calc = new Calculator();
		  calc.setInMemory(number);
		  double result = calc.getMemoryResult();
		  Assert.assertEquals(result, 1.0);   	  
	  }
	  
	  @Test (groups = "Memory tests")
	  public void testAddInMemory(){
		  Calculator calc = new Calculator();
		  calc.addInMemory(number);
		  double result = calc.getMemoryResult();
		  Assert.assertEquals(result, 1.0);
	  }
	  
	  @Test (groups = "Memory tests")
	  public void testSubstractFromMemory(){
		  Calculator calc = new Calculator();
		  calc.setInMemory(number);
		  calc.addInMemory(number);
		  calc.subtractFromMemory(number);
		  double result = calc.getMemoryResult();
		  Assert.assertEquals(result, 0.0);
	  }
}
