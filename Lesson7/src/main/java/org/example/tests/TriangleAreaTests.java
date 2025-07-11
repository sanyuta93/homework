package org.example.tests;

import org.example.TriangleArea;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleAreaTests {

    @Test
    public void testAreaWithPositiveValues() {
        assertEquals(TriangleArea.calculateArea(5, 4), 10.0);
    }

    @Test
    public void testAreaWithZeroBase() {
        assertEquals(TriangleArea.calculateArea(0, 4), 0.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAreaWithNegativeHeight() {
        TriangleArea.calculateArea(5, -1);
    }
}