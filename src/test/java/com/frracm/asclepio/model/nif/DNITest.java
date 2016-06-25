package com.frracm.asclepio.model.nif;

import static org.junit.Assert.*;

import org.junit.Test;

public class DNITest {

	@Test
	public void whenBuildDNIThenDNIIsNotNull() {
		assertNotNull(new DNI(12345678, 'Z'));
	}

	@Test
	public void whenDNINotBuiltThenDNIIsNull() {
		DNI dni = null;
		assertNull(dni);
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenIncorrectDNIIsBuiltThrowException() {
		new DNI(12345678, 'A');
	}

	@Test
	public void givenDNIValueIsCorrect() {
		Integer dniNumber = 12345678;
		char dniLetter = 'Z';
		DNI dni = new DNI(dniNumber, dniLetter);
		String expectedDNIValue = dniNumber.toString() + dniLetter;
		String actualDNIValue = dni.getValue();
		assertEquals(expectedDNIValue, actualDNIValue);
	}
}
