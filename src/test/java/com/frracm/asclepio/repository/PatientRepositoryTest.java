package com.frracm.asclepio.repository;

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
import org.springframework.data.mongodb.core.MongoTemplate;

import com.frracm.asclepio.model.Patient;

@RunWith(MockitoJUnitRunner.class)
public class PatientRepositoryTest {

	@Mock
	private MongoTemplate template;

	@InjectMocks
	private PatientRepository patientRepository;

	@Test
	public void whenGetAllIsInvockedThenGetAllFromMongo() {
		List<Patient> expected = new ArrayList<>();
		Patient patient = new Patient();
		patient.setNumeroHistoriaClinica(1L);
		expected.add(patient);
		Mockito.when(template.findAll(Patient.class)).thenReturn(expected);
		Collection<Patient> actual = patientRepository.getAll();
		assertNotNull(actual);
		assertTrue(actual.containsAll(expected));
		assertTrue(expected.containsAll(actual));
	}

	@Test
	public void givenPatientThenSaveIt() {
		Patient patient = new Patient();
		patient.setNumeroHistoriaClinica(1L);
		patientRepository.saveOrUpdate(patient);
		Mockito.verify(template).save(patient);
	}

	@Test
	public void givenIdThenDeleteIt() {
		Long numeroHistoriaClinica = 1L;
		Patient patient = new Patient();
		patient.setNumeroHistoriaClinica(numeroHistoriaClinica);
		patientRepository.remove(numeroHistoriaClinica);
		Mockito.verify(template).remove(patient);
	}

}
