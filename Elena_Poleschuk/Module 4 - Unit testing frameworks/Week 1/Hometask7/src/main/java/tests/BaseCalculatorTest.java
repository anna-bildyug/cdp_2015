package tests;
import org.testng.annotations.BeforeClass;

import com.epam.tat.module4.Calculator;

public class BaseCalculatorTest {
    protected Calculator calculator;

    @BeforeClass							
    public void setUp(){
        calculator = new Calculator();
    }


}
