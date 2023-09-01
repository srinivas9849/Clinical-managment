package com.clinicals.springboot.clinicalsdata.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.clinicals.springboot.clinicalsdata.entity.Compound;
import com.clinicals.springboot.clinicalsdata.entity.Patient;
import com.clinicals.springboot.clinicalsdata.entity.PatientsComponentResult;
import com.clinicals.springboot.clinicalsdata.entity.Result;
import com.clinicals.springboot.clinicalsdata.service.CompoundService;
import com.clinicals.springboot.clinicalsdata.service.PatientService;

@Component
public class ResultUtility {
	
	@Autowired
	private PatientService patientService;
	@Autowired
	private CompoundService compoundService;
	
	public PatientsComponentResult getPatientsComponentResultObject(Result result) {

		Compound compound=compoundService.getCompoundById(result.getCompound_id());
		Patient patient=patientService.getPatientById(result.getPatient_id());
		PatientsComponentResult obj=new PatientsComponentResult(compound, patient, result.getVal(), result.getDesc(), result.getDate());
	
		obj.setId(result.getId());
		return obj;
	
	}
	public Result getResult(PatientsComponentResult patientsComponentResult) {
		Result result=new Result(patientsComponentResult.getId(),
				patientsComponentResult.getPatient().getId(),
				patientsComponentResult.getCompound().getId(),
				patientsComponentResult.getVal(),
				patientsComponentResult.getDesc(),
				patientsComponentResult.getDate());
		return result;
	}
	

}
