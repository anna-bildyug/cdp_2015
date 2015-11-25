package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TrigonometryTest extends BaseCalculatorTest {

    @Test(groups = "trigonometry")
    public void powTest(){
        double result = calculator.pow(3, 2);
        Assert.assertEquals(result, 9.0, "Invalid result of operation");
    }

    @Test(groups = "trigonometry")
    public void sqrtTest(){
        double result = calculator.sqrt(16);
        Assert.assertEquals(result, 4.0, "Invalid result of operation");
    }
    
    @Test(groups = "trigonometry")
    public void sqrtNegativeTest(){
        double result = calculator.sqrt(-16);
        Assert.assertEquals(result, 4.0, "Invalid result of operation");
    }

    @Test(groups = "trigonometry")
    public void tgTest(){
        double result = calculator.tg(45);
        Assert.assertEquals(result, 1.0, "Invalid result of operation");
    }

    @Test(groups = "trigonometry", expectedExceptions = IllegalArgumentException.class)
    public void tgOf90Test(){
        calculator.tg(90);
    }

    @Test(groups = "trigonometry")
    public void ctgTest(){
        double result = calculator.ctg(45);
        Assert.assertEquals(result, 1.0, "Invalid result of operation");
    }

    @Test(groups = "trigonometry", expectedExceptions = IllegalArgumentException.class)
    public void ctgOf0Test(){
        calculator.ctg(0);
    }

    @Test(groups = "trigonometry")
    public void cosTest(){
        double result = calculator.cos(0);
        Assert.assertEquals(result, 1.0, "Invalid result of operation");
    }
    @Test(groups = "trigonometry")
    public void sinTest(){
        double result = calculator.sin(30);
        Assert.assertEquals(result, 0.5, "Invalid result of operation");
    }

}
