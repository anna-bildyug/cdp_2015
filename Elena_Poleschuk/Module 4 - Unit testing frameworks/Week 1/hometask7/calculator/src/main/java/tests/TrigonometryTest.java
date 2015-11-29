package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import main.BaseCalculatorTest;

public class TrigonometryTest extends BaseCalculatorTest {

	@Test
	public void tgTest() {
		double result = calculator.tg(45);
		Assert.assertEquals(result, 1.0, "Invalid result of operation of tg caculation");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void tgOfNinetyTest() {
		calculator.tg(90);
	}

	@Test
	public void ctgTest() {
		double result = calculator.ctg(45);
		Assert.assertEquals(result, 1.0, "Invalid result of operation of ctg caculation");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void ctgOfZeroTest() {
		calculator.ctg(0);
	}

	@Test
	public void cosTest() {
		double result = calculator.cos(0);
		Assert.assertEquals(result, 1.0, "Invalid result of operation of cos caculation");
	}

	@Test
	public void sinTest() {
		double result = calculator.sin(30);
		Assert.assertEquals(result, 0.5, "Invalid result of operation of sin caculation");
	}

}
