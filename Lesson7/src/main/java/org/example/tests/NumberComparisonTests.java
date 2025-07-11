package org.example.tests;

import org.example.NumberComparison;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class NumberComparisonTests {

    @Test
    public void testFirstNumberGreater() {
        assertEquals(NumberComparison.compare(5, 3), "5 больше 3");
    }

    @Test
    public void testSecondNumberGreater() {
        assertEquals(NumberComparison.compare(2, 4), "2 меньше 4");
    }

    @Test
    public void testNumbersEqual() {
        assertEquals(NumberComparison.compare(7, 7), "Числа равны");
    }
}