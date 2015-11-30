package by.epam.cdp.java.moduletesting;

import org.testng.annotations.Test;
import epam.cdp.javabasics_testng.L2.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

public class BasicOperationsTests {
	
	private double firstNumber;
	private double secondNumber;
	
  @Factory(dataProvider = "dataProvider")
   public BasicOperationsTests (double firstNumber,double secondNumber){
	  this.firstNumber = firstNumber;
	  this.secondNumber = secondNumber;
  }
  
  @DataProvider
  public static Object [][] dataProvider(){		  
	  return new Object [][] {{8,12},{-10,3},{10,0}};	 		  
  }
	
  @Test (groups = "Math operations")
  public void additionTest() {
	Calculator calc = new Calculator();
	double result = calc.addition(firstNumber, secondNumber);
	Assert.assertEquals(result, firstNumber + secondNumber);
  }
  
  @Test (groups = "Math operations")
  public void divisionTest (){
	  Calculator calc = new Calculator();
	  double result = calc.division(firstNumber, secondNumber);
	  Assert.assertEquals(result, firstNumber / secondNumber);
  }
  
  @Test (groups = "Math operations")
  public void testMultiplication (){
	  Calculator calc = new Calculator();
	  double result = calc.multiplication(firstNumber, secondNumber);
	  Assert.assertEquals(result, firstNumber * secondNumber);
  }
  
  @Test (groups = "Math operations")
  public void testSubstraction (){
	  Calculator calc = new Calculator();
	  double result = calc.subtraction(firstNumber, secondNumber);
	  Assert.assertEquals(result, firstNumber - secondNumber);
  }
}
