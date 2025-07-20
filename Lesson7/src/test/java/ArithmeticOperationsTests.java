import org.example.ArithmeticOperations;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArithmeticOperationsTests {

    @Test
    public void testAddition() {
        assertEquals(ArithmeticOperations.add(2, 3), 5);
    }

    @Test
    public void testSubtraction() {
        assertEquals(ArithmeticOperations.subtract(2, 3), -1);
    }

    @Test
    public void testMultiplication() {
        assertEquals(ArithmeticOperations.multiply(2, 3), 6);
    }

    @Test
    public void testDivision() {
        assertEquals(ArithmeticOperations.divide(6, 3), 2.0);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        ArithmeticOperations.divide(5, 0);
    }
}