import org.example.NumberComparison;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberComparisonTests {

    @Test
    public void testFirstNumberGreater() {
        assertEquals("5 больше 3", NumberComparison.compare(5, 3));
    }

    @Test
    public void testSecondNumberGreater() {
        assertEquals("2 меньше 4", NumberComparison.compare(2, 4));
    }

    @Test
    public void testNumbersEqual() {
        assertEquals("Числа равны", NumberComparison.compare(7, 7));
    }
}
