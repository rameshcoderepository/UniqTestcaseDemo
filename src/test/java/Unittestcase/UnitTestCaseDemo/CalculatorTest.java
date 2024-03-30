package Unittestcase.UnitTestCaseDemo;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator calculator = new Calculator();
		int result = calculator.add(2, 3);
		assertEquals(5, result);
	}

	@Test
	public void testAdd1() {
		Calculator calculator = new Calculator();
		int result = calculator.add(2, 3);
		assertEquals(5, result);
	}

	@Test
	public void testSubtract() {
		Calculator calculator = new Calculator();
		int result = calculator.subtract(5, 2);
		assertEquals(3, result);
	}

	@Test
	public void testMultiply() {
		Calculator calculator = new Calculator();
		int result = calculator.multiply(2, 4);
		assertEquals(8, result);
	}

	@Test
	public void testDivide() {
		Calculator calculator = new Calculator();
		double result = calculator.divide(10, 2);
		assertEquals(5.0, result, 0.0001); // Adding delta for double comparison

		// Test divide by zero
		try {
			calculator.divide(5, 0);
			// If no exception is thrown, fail the test
			org.junit.Assert.fail("Expected IllegalArgumentException was not thrown.");
		} catch (IllegalArgumentException e) {
			assertEquals("Cannot divide by zero.", e.getMessage());
		}
	}
}
