package com.frracm.asclepio.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.frracm.asclepio.model.Patient;
import com.frracm.asclepio.model.Sex;
import com.frracm.asclepio.service.PatientService;
import com.frracm.asclepio.utils.UrlPathConstants;

@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;

	@RequestMapping(value = "/" + UrlPathConstants.PATIENT + "/ejemplo", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public Patient example() {
		Patient patient = new Patient();
		patient.setAddress("Calle del pepino");
		patient.setApellido1("Sánchez");
		patient.setApellido2("Zehcnás");
		patient.setBirthDate(new Date());
		patient.setBirthPlace("Cuenca");
		// patient.setIdentityDocument(identityDocument);
		patient.setNationality("Cuencuense");
		patient.setNombre("Federico");
		patient.setNumeroHistoriaClinica(854112L);
		List<String> phoneNumbers = new ArrayList<>();
		phoneNumbers.add("956989863");
		patient.setPhoneNumbers(phoneNumbers);
		patient.setSex(Sex.MALE);
		patient.setSocialSecurityNumber("SegSoc 4556/2");
		return patient;
	}

	@RequestMapping(value = "/" + UrlPathConstants.PATIENT, method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public Collection<Patient> list() {
		return patientService.getAll();
	}
}
