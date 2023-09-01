package com.clinicals.springboot.clinicalsdata.service;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.Rollback;

import com.clinicals.springboot.clinicalsdata.entity.Patient;
import com.clinicals.springboot.clinicalsdata.repo.PatientRepo;

import jakarta.transaction.Transactional;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

	@Mock
	private PatientRepo patientRepo;

	@InjectMocks
	PatientService patientService;
	List<Patient> patients=null;
	
	@BeforeEach
	public void load() {
		patients= new ArrayList<>();
		patients.add(new Patient(1L, "srinivas", "peram", LocalDate.now(), "1234567890", "abc@gmail.com", "hyderabad",
				null));
		patients.add(new Patient(2L, "srinivas", "peram", LocalDate.now(), "1234567890", "abc@gmail.com", "hyderabad",
				null));
		patients.add(new Patient(3L, "srinivas", "peram", LocalDate.now(), "1234567890", "abc@gmail.com", "hyderabad",
				null));
		patients.add(new Patient(4L, "srinivas", "peram", LocalDate.now(), "1234567890", "abc@gmail.com", "hyderabad",
				null));
	}

	@Test
	public void testGetPatients() {
		when(patientService.getPatients()).thenReturn(patients);
		List<Patient> actual=patientService.getPatients();
	    Assertions.assertEquals(patients,actual);


	}
	@Test
	public void testgetPatientById() {
		Optional<Patient> patient=Optional.of(patients.get(0));
		when(patientRepo.findById(1L)).thenReturn(patient);
		Patient actual = patientService.getPatientById(1);
		Assertions.assertEquals(patient.get(),actual);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testDeletePatientById() {
		patientService.addPatient(new Patient(99999L, "srinivas", "peram", LocalDate.now(), "1234567890", "abc@gmail.com", "hyderabad",null));
	    patientService.deletePatientById(99999L);
	    patients = patientService.getPatients();
	    boolean found=false;
	    for(Patient p:patients) {
	    	if(p.getId()==99999L) {
	    		found=true;
	    	}
	    }
	    
	    Assertions.assertEquals(false,found);
		
	
	}

}
