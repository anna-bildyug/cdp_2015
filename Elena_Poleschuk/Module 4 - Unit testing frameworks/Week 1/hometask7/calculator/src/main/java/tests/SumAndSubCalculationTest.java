package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import main.BaseCalculatorTest;

public class SumAndSubCalculationTest extends BaseCalculatorTest {

	@Test
	public void sumLongTest() {
		long result = calculator.sum(10, 2);
		Assert.assertEquals(result, 12, "Invalid result of summation for Long Numbers");
	}

	@Test
	public void sumDoubleTest() {
		double result = calculator.sum(1.1, 2.2);
		Assert.assertEquals(result, 3.3, "Invalid result of summation for Double Numbers");
	}

	@Test
	public void subLongTest() {
		long result = calculator.sub(6, 10);
		Assert.assertEquals(result, -4, "Invalid result of subtraction for Long Numbers");
	}

	@Test
	public void subDoubleTest() {
		double result = calculator.sub(5.5, 2.2);
		Assert.assertEquals(result, 3.3, "Invalid result of subtraction for Double Numbers");
	}

}
