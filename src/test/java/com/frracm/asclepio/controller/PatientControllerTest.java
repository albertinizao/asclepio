package com.frracm.asclepio.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.frracm.asclepio.model.Patient;
import com.frracm.asclepio.service.PatientService;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {

	@Mock
	private PatientService patientService;

	@InjectMocks
	private PatientController patientController;

	@Test
	public void whenGetAllThenInvokeGetAll() {
		List<Patient> expected = new ArrayList<>();
		Patient patient = new Patient();
		patient.setNumeroHistoriaClinica(1L);
		expected.add(patient);
		Mockito.when(patientService.getAll()).thenReturn(expected);
		Collection<Patient> actual = patientController.list();
		assertNotNull(actual);
		assertTrue(actual.containsAll(expected));
		assertTrue(expected.containsAll(actual));
	}

}
