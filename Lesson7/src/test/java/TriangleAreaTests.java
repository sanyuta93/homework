import org.example.TriangleArea;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleAreaTests {

    @Test
    public void testAreaWithPositiveValues() {
        assertEquals(10.0, TriangleArea.calculateArea(5, 4));
    }

    @Test
    public void testAreaWithZeroBase() {
        assertEquals(0.0, TriangleArea.calculateArea(0, 4));
    }

    @Test
    public void testAreaWithNegativeHeight() {
        assertThrows(IllegalArgumentException.class, () -> TriangleArea.calculateArea(5, -1));
    }
}
