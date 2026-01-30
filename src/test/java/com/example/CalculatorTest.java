package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {
        assertEquals(15, calculator.calculate(10, 5, "add"));
    }

    @Test
    public void testAddAgain() {
        assertEquals(15, calculator.calculate(10, 5, "add-again"));
    }

    @Test
    public void testSubtraction() {
        assertEquals(5, calculator.calculate(10, 5, "sub"));
    }

    @Test
    public void testSubAgain() {
        assertEquals(5, calculator.calculate(10, 5, "sub-again"));
    }

    @Test
    public void testMultiplication() {
        assertEquals(50, calculator.calculate(10, 5, "mul"));
    }

    @Test
    public void testDivision() {
        assertEquals(2, calculator.calculate(10, 5, "div"));
    }

    @Test
    public void testDivisionByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, 
            () -> calculator.calculate(10, 0, "div"));
        assertEquals("Division by zero", exception.getMessage());
    }

    @Test
    public void testModulo() {
        assertEquals(1, calculator.calculate(10, 3, "mod"));
    }

    @Test
    public void testModuloByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, 
            () -> calculator.calculate(10, 0, "mod"));
        assertEquals("Modulo by zero", exception.getMessage());
    }

    @Test
    public void testPower() {
        assertEquals(100, calculator.calculate(10, 2, "pow"));
    }

    @Test
    public void testPowerZero() {
        assertEquals(1, calculator.calculate(10, 0, "pow"));
    }

    @Test
    public void testPowerOne() {
        assertEquals(5, calculator.calculate(5, 1, "pow"));
    }

    @Test
    public void testUnknownOperation() {
        Exception exception = assertThrows(IllegalArgumentException.class, 
            () -> calculator.calculate(10, 5, "unknown"));
        assertEquals("Unknown operation: unknown", exception.getMessage());
    }
}