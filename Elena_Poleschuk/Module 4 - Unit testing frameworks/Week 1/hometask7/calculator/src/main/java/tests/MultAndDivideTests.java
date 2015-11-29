package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import main.BaseCalculatorTest;

public class MultAndDivideTests extends BaseCalculatorTest {

	@Test(groups = "mult", priority = 0)
	public void multLongTest() {
		long result = calculator.mult(2, 2);
		Assert.assertEquals(result, 4, "Invalid result of multiplication for Long numbers");
	}

	@Test(groups = "mult", priority = 1)
	public void multDoubleTest() {
		double result = calculator.mult(2.2, 2.2);
		Assert.assertEquals(result, 4.84, "Invalid result of multiplication for Double numbers");
	}

	@Test(groups = "div", priority = 0)
	public void divLongTest() {
		long result = calculator.div(2, 2);
		Assert.assertEquals(result, 1, "Invalid result of division for Long numbers");
	}

	@Test(groups = "div", priority = 1)
	public void divDoubleTest() {
		double result = calculator.div(11.55, 2.1);
		Assert.assertEquals(result, 5.5, "Invalid result of division for Double numbers");
	}

	@Test(expectedExceptions = IllegalArgumentException.class, groups = "div", priority = 2)
	public void divByZeroLongTest() {
		calculator.div(2, 0);
	}

	@Test(expectedExceptions = IllegalArgumentException.class, groups = "div", priority = 3)
	public void divByZeroDoubleTest() {
		calculator.div(2.1, 0);
	}

}
