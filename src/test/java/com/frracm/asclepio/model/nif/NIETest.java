package com.frracm.asclepio.model.nif;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class NIETest {
	@Test
	public void whenBuildNIEThenNIEIsNotNull() {
		assertNotNull(new NIE('Y', 2345678, 'Z'));
	}

	@Test
	public void whenNIENotBuiltThenNIEIsNull() {
		NIE nie = null;
		assertNull(nie);
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenIncorrectNIEIsBuiltThrowException() {
		new NIE('X', 2345678, 'Z');
	}

	@Test
	public void givenNIEValueIsCorrect() {
		char nieInitialLetter = 'Y';
		int nieNumber = 2345678;
		char nieFinalLetter = 'Z';
		NIE nie = new NIE(nieInitialLetter, nieNumber, nieFinalLetter);
		String expectedNIEValue = (new StringBuilder()).append(nieInitialLetter).append(nieNumber).append(nieFinalLetter).toString();
		String actualNIEValue = nie.getValue();
		assertEquals(expectedNIEValue, actualNIEValue);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void givenNIEValueIsNotCorrect() {
		char nieInitialLetter = 'X';
		int nieNumber = 2345678;
		char nieFinalLetter = 'Z';
		NIE nie = new NIE(nieInitialLetter, nieNumber, nieFinalLetter);
	}
}
