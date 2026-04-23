package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * JUnit 5 tests for the GradeCalculator class.
 */
public class GradeCalculatorTest {

    @Test
    public void testAverageReturnsCorrectAverage() {
        GradeCalculator calculator = new GradeCalculator();

        double result = calculator.average(90, 80, 70);

        assertEquals(80.0, result);
    }

    @Test
    public void testLetterGradeReturnsCorrectGrade() {
        GradeCalculator calculator = new GradeCalculator();

        String result = calculator.letterGrade(85);

        assertEquals("B", result);
    }

    @Test
    public void testIsPassingReturnsTrueForPassingAverage() {
        GradeCalculator calculator = new GradeCalculator();

        boolean result = calculator.isPassing(60);

        assertTrue(result);
    }

    @Test
    public void testLetterGradeBoundaryAt90ReturnsA() {
        GradeCalculator calculator = new GradeCalculator();

        String result = calculator.letterGrade(90);

        assertEquals("A", result);
    }

    @Test
    public void testIsPassingBoundaryAt59Point9ReturnsFalse() {
        GradeCalculator calculator = new GradeCalculator();

        boolean result = calculator.isPassing(59.9);

        assertFalse(result);
    }

    @Test
    public void testAverageThrowsExceptionForNegativeScore() {
        GradeCalculator calculator = new GradeCalculator();

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(-1, 80, 90);
        });
    }

    @Test
    public void testAverageThrowsExceptionForScoreAbove100() {
        GradeCalculator calculator = new GradeCalculator();

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(101, 80, 90);
        });
    }
}