package com.clinicals.springboot.clinicalsdata.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.clinicals.springboot.clinicalsdata.entity.Patient;
import com.clinicals.springboot.clinicalsdata.entity.PatientsComponentResult;
import com.clinicals.springboot.clinicalsdata.repo.PatientRepo;

@Controller
public class AnalyzeController {
	@Autowired 
	private PatientRepo patientRepo;
	
	
	 
	@RequestMapping("/analyze-patient")
	public String getDataForAnalyze(@RequestParam("patient_id") long id,ModelMap model){
		Map<String, List<Map<Object, Object>>> canvasjsDataList = new HashMap<>();
		
		
		Optional<Patient> findById = patientRepo.findById(id);
		
		List<PatientsComponentResult> results = findById.get().getResults();
		System.out.println(results);
		for(PatientsComponentResult r:results) {
			
			String compoundName=r.getCompound().getName()+"-"+r.getCompound().getId();
			Map<Object,Object> map = new HashMap<>();
			map.put("x", r.getDate()); map.put("y", r.getVal());
			
			
			
			if(canvasjsDataList.containsKey(compoundName)) {
				

				canvasjsDataList.get(compoundName).add(map);	
			}
			else {
				ArrayList<Map<Object, Object>> result = new ArrayList<Map<Object, Object>>();
				result.add(map);
				canvasjsDataList.put(compoundName,result);
				
				
			}
			
		}
		model.addAttribute("dataPointsList", canvasjsDataList);
		model.addAttribute("dataSize", canvasjsDataList.size());

		
		return "analyze";
		
	}
	
	
	

}
