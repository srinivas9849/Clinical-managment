package com.clinicals.springboot.clinicalsdata.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicals.springboot.clinicalsdata.entity.PatientsComponentResult;
import com.clinicals.springboot.clinicalsdata.entity.Result;
import com.clinicals.springboot.clinicalsdata.repo.PatientRepo;
import com.clinicals.springboot.clinicalsdata.repo.PatientsComponentResultRepo;
import com.clinicals.springboot.clinicalsdata.utility.ResultUtility;

@Service
public class PatientsComponentResultService {
	
	@Autowired
	private ResultUtility resultUtility;
	
	@Autowired 
	private PatientsComponentResultRepo patientsComponentResultRepo;
	
	
	public static List<PatientsComponentResult> res=new ArrayList<PatientsComponentResult>();
	
	public void addPatientsComponentResultByResult(Result result) {
		PatientsComponentResult patientsComponentResultObject = resultUtility.getPatientsComponentResultObject(result);
		
		patientsComponentResultRepo.save(patientsComponentResultObject);
	}

	public Result getResult(long id) {
		Optional<PatientsComponentResult> findById = patientsComponentResultRepo.findById(id);
		PatientsComponentResult patientsComponentResult = findById.get();
		Result result = resultUtility.getResult(patientsComponentResult);
		return result;
		
		
	}

	public void updatePatientsComponentResultByResult(Result result) {
		PatientsComponentResult patientsComponentResultObject = resultUtility.getPatientsComponentResultObject(result);
		System.out.println("result id at update : "+ result.getId());
		patientsComponentResultRepo.save(patientsComponentResultObject);
		
	}
	

}
