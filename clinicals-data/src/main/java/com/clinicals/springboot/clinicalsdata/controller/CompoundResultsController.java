package com.clinicals.springboot.clinicalsdata.controller;

import java.util.Collections;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.clinicals.springboot.clinicalsdata.entity.Patient;
import com.clinicals.springboot.clinicalsdata.entity.PatientsComponentResult;
import com.clinicals.springboot.clinicalsdata.entity.Result;
import com.clinicals.springboot.clinicalsdata.service.CompoundService;
import com.clinicals.springboot.clinicalsdata.service.PatientService;
import com.clinicals.springboot.clinicalsdata.service.PatientsComponentResultService;

import jakarta.validation.Valid;
@Controller
@SessionAttributes("patient_name")
public class CompoundResultsController {
	
	@Autowired
	private CompoundService compoundService; 
	
	@Autowired
	private PatientsComponentResultService componentResultService;
	
	@Autowired
	PatientService patientService;
	
	
	
	@RequestMapping(value = "/show-results-of-patient",method = RequestMethod.GET)	
	public String showPatientResults(@RequestParam("id") long id, ModelMap model) {
		
		Patient patient = patientService.getPatientById(id);
		
		if(!patient.getResults().isEmpty()) {
		Collections.sort(patient.getResults(),new SortCompare());
		System.out.println(patient.getResults());
		
		}
		model.put("patient", patient);
		model.put("patient_name", patient.getLastName());
		model.put("size",patient.getResults().size());
		model.put("clicked", 0);
		
		return "compound-result";
		
	}
	
	
	
	@RequestMapping(value = "/add-result-to-patient",method = RequestMethod.GET)
	public String showAddCompundResultsPage(@RequestParam("patient_id") long id,@ModelAttribute("result") Result result,ModelMap model) {

		model.put("compounds", compoundService.getCompounds());
		model.put("p_id", id);
		return "add-compound-results";
	}
	@RequestMapping(value="/add-compound-result",method = RequestMethod.POST)
	public String addComponentResults(@Valid @ModelAttribute("result") Result result,BindingResult errors,ModelMap model) {
		if(errors.hasErrors()) {
			model.put("compounds", compoundService.getCompounds());
			model.put("p_id", result.getPatient_id());
		   return "add-compound-results";
		}
		componentResultService.addPatientsComponentResultByResult(result);
		return "redirect:/show-results-of-patient"+"?id="+result.getPatient_id();
	}
	
	@RequestMapping(value = "/update-result-to-patient",method = RequestMethod.GET)
	public String showUpdateCompundResultsPage(@RequestParam("result_id") long id,ModelMap model) {

		Result result = componentResultService.getResult(id);
		model.put("result",result);
		model.put("p_id", result.getPatient_id());
		model.put("c_id", result.getCompound_id());

		return "update-compound-result";
	}
	@RequestMapping(value = "/update-result-to-patient",method = RequestMethod.POST)
	public String updateCompundResultsPage(@Valid @ModelAttribute("result") Result result,BindingResult error,ModelMap model) {
		if(error.hasErrors()) {
			model.put("result",result);
			model.put("p_id", result.getPatient_id());
			model.put("c_id", result.getCompound_id());
			return "update-compound-result";

		}

		componentResultService.updatePatientsComponentResultByResult(result);
		return "redirect:/show-results-of-patient"+"?id="+result.getPatient_id();
	}
	
	
	
	
	
	
	

}

class SortCompare implements Comparator<PatientsComponentResult>   
{  
    @Override  
    // Method of this class  
    public int compare(PatientsComponentResult a,PatientsComponentResult b)  
    {  
        /* Returns sorted data in Descending order */  
        return a.getDate().compareTo(b.getDate());  
    }  
}  
