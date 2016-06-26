package com.frracm.asclepio.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frracm.asclepio.model.Patient;
import com.frracm.asclepio.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	public Collection<Patient> getAll() {
		return patientRepository.getAll();
	}

	public void saveOrUpdate(Patient patient) {
		patientRepository.saveOrUpdate(patient);
	}

	public void remove(Long numeroHistoriaClinica) {
		patientRepository.remove(numeroHistoriaClinica);
	}
}
