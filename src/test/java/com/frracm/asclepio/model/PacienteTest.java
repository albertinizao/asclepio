package com.frracm.asclepio.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class PacienteTest {

	@Test
	public void givenPatientWithPhoneNumbersTestImmutable() {
		Patient patient = new Patient();
		List<String> phoneList = new ArrayList<String>();
		phoneList.add("928123456");
		patient.setPhoneNumbers(phoneList);
		List<String> actualPhoneList = patient.getPhoneNumbers();
		assertTrue(actualPhoneList.containsAll(phoneList));
		assertTrue(phoneList.containsAll(actualPhoneList));
		phoneList.add("910234567");
		assertTrue(phoneList.containsAll(actualPhoneList));
		assertFalse(actualPhoneList.containsAll(phoneList));
	}

	@Test
	public void givenPatientWithBirthDateTestImmutable() {
		Patient patient = new Patient();
		Date date = new Date();
		date.setDate(1);
		date.setMonth(7);
		date.setYear(1989);
		patient.setBirthDate(date);
		Date actualDate = patient.getBirthDate();
		assertEquals(date.getTime(), actualDate.getTime());
		date.setMonth(8);
		assertNotEquals(date.getTime(), actualDate.getTime());
	}
}
