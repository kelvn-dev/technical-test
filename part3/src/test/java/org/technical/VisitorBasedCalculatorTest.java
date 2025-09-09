package org.technical;

import org.junit.jupiter.api.Test;
import org.technical.core.calculator.Calculator;
import org.technical.core.calculator.VisitorBasedCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VisitorBasedCalculatorTest {

    private final Calculator calculator = new VisitorBasedCalculator();

    @Test
    void testAddition() {
        assertEquals(7.0, calculator.calculate("3 + 4"));
    }

    @Test
    void testParentheses() {
        assertEquals(20.0, calculator.calculate("(2 + 3) * 4"));
    }

    @Test
    void testPower() {
        assertEquals(8.0, calculator.calculate("2 ^ 3"));
    }

    @Test
    void testAll() {
        assertEquals(-55.0, calculator.calculate("-(3 + 2) ^ 2 * 4 / 2 - 5\n"));
    }

    @Test
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate("3 + "));
    }
}
