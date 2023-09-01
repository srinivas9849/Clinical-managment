package com.clinicals.springboot.clinicalsdata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.clinicals.springboot.clinicalsdata.entity.Patient;
import com.clinicals.springboot.clinicalsdata.entity.PatientsComponentResult;
import com.clinicals.springboot.clinicalsdata.repo.PatientRepo;

import jakarta.transaction.Transactional;

@Service
public class PatientService {
	@Autowired 
	private PatientRepo patientRepo;
	
	
	@Transactional
	public List<Patient> getPatients(){
		
		return (List<Patient>) patientRepo.findAll(Sort.by(Order.by("id")));
	}
	@Transactional
	public Patient getPatientById(long id) {
		Optional<Patient> findById = patientRepo.findById(id);
		return findById.get();
		
	}
	@Transactional
	public void deletePatientById(long id) {
		patientRepo.deleteById(id);
	}
	@Transactional
	public void addPatient(Patient patient) {
		patientRepo.save(patient);
	}
	@Transactional
	public void updateCompound(Patient patient) {
		patientRepo.save(patient);
		
	}
	@Transactional
	public List<PatientsComponentResult> getResultsByPatientId(long id){
		Patient patient = this.getPatientById(id);
		return patient.getResults();

	}
	@Transactional
	public List<Patient> searchPatientWithName(String firstName){
		return patientRepo.searchPatient(firstName);
	}
	
	
	
	

}
