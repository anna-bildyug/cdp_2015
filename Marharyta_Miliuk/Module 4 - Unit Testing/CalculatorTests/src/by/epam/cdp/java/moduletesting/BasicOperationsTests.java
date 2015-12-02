package by.epam.cdp.java.moduletesting;

import org.testng.annotations.Test;
import epam.cdp.javabasics_testng.L2.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

public class BasicOperationsTests {
	
	private double firstNumber;
	
  @Factory(dataProvider = "dataProvider")
   public BasicOperationsTests (double firstNumber){
	  this.firstNumber = firstNumber;
  }
  
  @DataProvider
  public static Object [][] dataProvider(){		  
	  return new Object [][] {{10}};	 		  
  }
	
  @Test (groups = "Math operations")
  public void additionTest() {
	Calculator calc = new Calculator();
	double result = calc.addition(firstNumber, 2.0);
	Assert.assertEquals(result, 12.0);
  }
  
  @Test (groups = "Math operations")
  public void divisionTest (){
	  Calculator calc = new Calculator();
	  double result = calc.division(firstNumber, 2.0);
	  Assert.assertEquals(result, 5.0);
  }
  
  @Test (groups = "Math operations")
  public void testMultiplication (){
	  Calculator calc = new Calculator();
	  double result = calc.multiplication(firstNumber, 2.0);
	  Assert.assertEquals(result, 20.0);
  }
  
  @Test (groups = "Math operations")
  public void testSubstraction (){
	  Calculator calc = new Calculator();
	  double result = calc.subtraction(firstNumber, 2.0);
	  Assert.assertEquals(result, 8.0);
  }
}
