package com.frracm.asclepio.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.frracm.asclepio.model.Patient;
import com.frracm.asclepio.repository.PatientRepository;

@RunWith(MockitoJUnitRunner.class)
public class PatientServiceTest {

	@Mock
	private PatientRepository patientRepository;

	@InjectMocks
	private PatientService patientService;

	@Test
	public void whenGetAllIsInvockedThenGetAllFromMongo() {
		List<Patient> expected = new ArrayList<>();
		Patient patient = new Patient();
		patient.setNumeroHistoriaClinica(1L);
		expected.add(patient);
		Mockito.when(patientRepository.getAll()).thenReturn(expected);
		Collection<Patient> actual = patientService.getAll();
		assertNotNull(actual);
		assertTrue(actual.containsAll(expected));
		assertTrue(expected.containsAll(actual));
	}

	@Test
	public void givenPatientThenSaveIt() {
		Patient patient = new Patient();
		patient.setNumeroHistoriaClinica(1L);
		patientService.saveOrUpdate(patient);
		Mockito.verify(patientRepository).saveOrUpdate(patient);
	}

	@Test
	public void givenIdThenDeleteIt() {
		Long numeroHistoriaClinica = 1L;
		patientService.remove(numeroHistoriaClinica);
		Mockito.verify(patientRepository).remove(numeroHistoriaClinica);
	}
}
