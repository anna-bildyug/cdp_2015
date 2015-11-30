package by.epam.cdp.java.moduletesting;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import epam.cdp.javabasics_testng.L2.Calculator;

public class NumberOperationsTests {
	
	private double number;

	 @Factory(dataProvider = "dataProvider")
	   public NumberOperationsTests (double number){
		  this.number = number;	
	  }
	 
	  @DataProvider
	  public static Object [][] dataProvider(){		  
		  return new Object [][] {{12},{-10},{0}};	 		  
	  }
	
	  @Test (groups = "Math operations")
	  public void testAbsoluteValue (){
		Calculator calc = new Calculator();
		double result = calc.absoluteValue(number);
		Assert.assertEquals(result, Math.abs(number));
	  }
	  
	  @Test (groups = "Angle operations")
	  public void testCos (){
		 Calculator calc = new Calculator();
		 double result = calc.cos(number);
		 Assert.assertEquals(result, Math.cos(number));
	  }
	  @Test (groups = "Math operations")
	  public void testFactorial (){
		  Calculator calc = new Calculator();
		  double fact = 1; 
	        for (int i = 1; i <= number; i++) {
	            fact *= i;
	        }
		  double result = calc.factorial(number);
	      Assert.assertEquals(result, fact);
	  }
	  @Test (groups = "Math operations")
	  public void testLg (){
		  Calculator calc = new Calculator();
		  double result = calc.lg(number);
		  Assert.assertEquals(result, Math.log(number));
	  }
	  @Test (groups = "Math operations")
	  public void testRoundToInteger (){
		  Calculator calc = new Calculator();
		  double result = calc.roundToInteger(number);
		  Assert.assertEquals(result, Math.ceil(number));
	  }
	  @Test (groups = "Angle operations")
	  public void testSin (){
		  Calculator calc = new Calculator();
		  double result = calc.sin(number);
		  Assert.assertEquals(result, Math.sin(number));
	  }
	  @Test (groups = "Angle operations")
	  public void testSquareRoot(){
		  Calculator calc = new Calculator();
		  double result = calc.squareRoot(number);
		  Assert.assertEquals(result, Math.sqrt(number));
	  }
	  @Test (groups = "Angle operations")
	  public void testTan(){
		  Calculator calc = new Calculator();
		  double result = calc.tan(number);
		  Assert.assertEquals(result, Math.tan(number));
	  }
	  @Test (groups = "Memory tests")
	  public void testSetGetFromMemory(){
		  Calculator calc = new Calculator();
		  calc.setInMemory(number);
		  double result = calc.getMemoryResult();
		  Assert.assertEquals(result, number);
	      	  
	  }
	  @Test (groups = "Memory tests")
	  public void testAddInSubstractFromMemory(){
		  Calculator calc = new Calculator();
		  calc.setInMemory(number);
		  calc.addInMemory(number);
		  calc.subtractFromMemory(number);
		  double result = calc.getMemoryResult();
		  Assert.assertEquals(result, 0.0);
	  }

}
