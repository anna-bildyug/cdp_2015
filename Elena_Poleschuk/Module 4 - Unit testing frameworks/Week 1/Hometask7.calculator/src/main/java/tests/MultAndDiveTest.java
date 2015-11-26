package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultAndDiveTest extends BaseCalculatorTest {

    @Test(groups = "mult", priority = 0)
    public void multLongTest(){
        long result = calculator.mult(2, 2);
        Assert.assertEquals(result, 4, "Invalid result of operation");
    }

	@Test(groups = "mult", priority = 1)
    public void multDoubleTest(){
        double result = calculator.mult(2.2, 2.2);
        Assert.assertEquals(result, 4.84, "Invalid result of operation");
    }

    @Test(groups = "div", priority = 0)
    public void divLongTest(){
        long result = calculator.div(2, 2);
        Assert.assertEquals( result, 1, "Invalid result of operation");
    }

    @Test(groups = "div", priority = 1)
    public void divDoubleTest(){
        double result = calculator.div(11.55, 2.1);
        Assert.assertEquals( result, 5.5, "Invalid result of operation");
    }

    @Test(expectedExceptions = IllegalArgumentException.class, groups = "div", priority = 2)
    public void divByZeroLongTest(){
        calculator.div(2, 0);
    }

    @Test( expectedExceptions = IllegalArgumentException.class, groups = "div", priority = 3)
    public void divByZeroDoubleTest(){
        calculator.div(2.1, 0);
    }


}
