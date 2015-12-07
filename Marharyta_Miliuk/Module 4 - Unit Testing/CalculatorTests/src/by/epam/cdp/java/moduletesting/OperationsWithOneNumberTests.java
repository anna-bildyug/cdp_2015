package by.epam.cdp.java.moduletesting;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import epam.cdp.javabasics_testng.L2.Calculator;

public class OperationsWithOneNumberTests {
	
	private double number;

	 @Factory(dataProvider = "dataProvider")
	   public OperationsWithOneNumberTests (double number){
		  this.number = number;	
	  }
	 
	  @DataProvider
	  public static Object [][] dataProvider(){		  
		  return new Object [][] {{1}};	 		  
	  }
	
	  @Test (groups = "Math operations")
	  public void testAbsoluteValue (){
		Calculator calc = new Calculator();
		double result = calc.absoluteValue(number);
		Assert.assertEquals(result, 1.0);
	  }
	  
	  @Test (groups = "Math operations")
	  public void testFactorial (){
		  Calculator calc = new Calculator();
		  double result = calc.factorial(number);
	      Assert.assertEquals(result, 1.0);
	  }
	  @Test (groups = "Math operations")
	  public void testLg (){
		  Calculator calc = new Calculator();
		  double result = calc.lg(number);
		  Assert.assertEquals(result, 0.0);
	  }
	  @Test (groups = "Math operations")
	  public void testRoundToInteger (){
		  Calculator calc = new Calculator();
		  double result = calc.roundToInteger(number);
		  Assert.assertEquals(result, 1.0);
	  }
	  @Test (groups = "Math operations")
	  public void testSquareRoot(){
		  Calculator calc = new Calculator();
		  double result = calc.squareRoot(number);
		  Assert.assertEquals(result, 1.0);
	  }
	 
}
