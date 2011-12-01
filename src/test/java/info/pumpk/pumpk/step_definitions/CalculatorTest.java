package info.pumpk.pumpk.step_definitions;

import info.pumpk.Pumpk;
import info.pumpk.annotations.Feature;
import info.pumpk.pumpk.lib.Calculator;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 * @author Gleb Galkin
 * @since 12/1/11
 */
@RunWith(Pumpk.class)
@Feature(path="calculator/features/addition.feature")
public class CalculatorTest {
    private  Calculator calculator;

    @Before
    public void before(){
        calculator = new Calculator();
    }


}
