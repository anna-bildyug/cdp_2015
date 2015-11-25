package tests;
import org.testng.Assert;
import org.testng.annotations.*;

public class PositiveNegativeTest extends BaseCalculatorTest{
    private long value;
    private boolean expectedPositiveValue;
    private boolean expectedNegativeValue;


    @Factory(dataProvider = "values")
    public PositiveNegativeTest(long value, boolean expectedPositiveValue, boolean expectedNegativeValue){
        this.value = value;
        this.expectedNegativeValue = expectedNegativeValue;
        this.expectedPositiveValue = expectedPositiveValue;
    }

    @Test(groups = "isPositiveNegative")
    public void checkValuePositive(){
    	 Assert.assertTrue(calculator.isPositive(value) == expectedPositiveValue, "Incorrect verification of positive value");
    }

    @Test(groups = "isPositiveNegative")
    public void checkValueNegative(){
    	 Assert.assertTrue(calculator.isNegative(value) == expectedNegativeValue, "Incorrect verification of negative value");
    }
    
    @DataProvider(name = "values")
    public static Object[][] valuesForCheck(){
        return new Object[][] {
            {1, true, false},
            {-1, false, true},
            {1000, true, false},
            {-1000, false, true},
            {0, false, false}
        };
    }
}
