import org.example.ArithmeticOperations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticOperationsTests {

    @Test
    public void testAddition() {
        assertEquals(5, ArithmeticOperations.add(2, 3));
    }

    @Test
    public void testSubtraction() {
        assertEquals(-1, ArithmeticOperations.subtract(2, 3));
    }

    @Test
    public void testMultiplication() {
        assertEquals(6, ArithmeticOperations.multiply(2, 3));
    }

    @Test
    public void testDivision() {
        assertEquals(2.0, ArithmeticOperations.divide(6, 3));
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(5, 0));
    }
}
