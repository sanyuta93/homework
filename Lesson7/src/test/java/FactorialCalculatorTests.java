import org.example.FactorialCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test()
public class FactorialCalculatorTests {
    @Test
    public void testFactorialOfZero() {
        Assert.assertEquals(FactorialCalculator.factorial(0), 1L);
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(FactorialCalculator.factorial(1), 1L);
    }

    @Test
    public void testFactorialOfFive() {
        assertEquals(FactorialCalculator.factorial(5), 120L);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        FactorialCalculator.factorial(-1);
    }
}