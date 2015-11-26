package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumAndSubCalculationTest extends BaseCalculatorTest {
	
    @Test(groups = "sum")
    public void sumLongTest(){
        long result = calculator.sum(10, 2);
        Assert.assertEquals(result, 12, "Invalid result of operation");
    }

    @Test(groups = "sum")
    public void sumDoubleTest(){
        double result = calculator.sum(1.1, 2.2);
        Assert.assertEquals(result, 3.3, "Invalid result of operation");
    }

    @Test(groups = "sub")
    public void subLongTest(){
        long result = calculator.sub(6, 10);
        Assert.assertEquals(result, -4, "Invalid result of operation");
    }

    @Test(groups = "sub")
    public void subDoubleTest(){
        double result = calculator.sub(5.5, 2.2);
        Assert.assertEquals(result, 3.3, "Invalid result of operation");
    }

}
