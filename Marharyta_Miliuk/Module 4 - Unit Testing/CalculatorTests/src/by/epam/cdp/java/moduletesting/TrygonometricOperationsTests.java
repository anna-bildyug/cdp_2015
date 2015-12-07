package by.epam.cdp.java.moduletesting;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import epam.cdp.javabasics_testng.L2.Calculator;

public class TrygonometricOperationsTests {
	
	private double number;
	
	  @Factory(dataProvider = "dataProvider")
	   public TrygonometricOperationsTests (double firstNumber){
		  this.number = number;
	  }
	  
	  @DataProvider
	  public static Object [][] dataProvider(){		  
		  return new Object [][] {{30}};	 		  
	  }
	
	@Test (groups = "Angle operations")
	  public void testCos (){
		 Calculator calc = new Calculator();
		 double result = calc.cos(number);
		 Assert.assertEquals(result, 1.0);
	  }
	
	 @Test (groups = "Angle operations")
	  public void testSin (){
		  Calculator calc = new Calculator();
		  double result = calc.sin(number);
		  Assert.assertEquals(result, 0.0);
	 }
	 
	  @Test (groups = "Angle operations")
	  public void testTan(){
		  Calculator calc = new Calculator();
		  double result = calc.tan(number);
		  Assert.assertEquals(result, 0.0);
	  }

}
