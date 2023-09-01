package com.clinicals.springboot.clinicalsdata.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinicals.springboot.clinicalsdata.entity.Patient;
import com.clinicals.springboot.clinicalsdata.service.PatientService;

import jakarta.validation.Valid;
@Controller
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	@RequestMapping(value = "/patients",method = RequestMethod.GET)	
	public String showAllTodos(ModelMap model) {
		List<Patient> patients = patientService.getPatients();
		model.put("patients", patients);
		model.put("clicked", 0);
		model.put("size",patients.size());

		return "patients";	
	}
	@RequestMapping(value="/add-patient",method = RequestMethod.GET)
	public String addPatient(@ModelAttribute("patient") Patient patient,ModelMap model) {
		model.put("clicked", 2);
		return "add-patient";
	}
	@RequestMapping(value="/add-patient",method = RequestMethod.POST)
	public String addTodo( @Valid @ModelAttribute("patient") Patient patient,BindingResult result) {
		if(result.hasErrors()) {
			return "add-patient";
		}
		
		
		patientService.addPatient(patient);
		System.out.println(patient);
		return "redirect:/patients";
	}
	
	
	@RequestMapping(value = "/update-patient")
	public String ShowUpdateTodoPage(@RequestParam("id") int id,ModelMap model) {
		Patient patient=patientService.getPatientById(id);
		model.put("patient",patient);
		return "update-patient";
	}
	@RequestMapping(value="/update-patient",method = RequestMethod.POST)
	public String updateTodo(@Valid @ModelAttribute("patient") Patient patient,BindingResult result) {
		if(result.hasErrors()) {
			return "update-patient";
		}
		
		patientService.updateCompound(patient);
		return "redirect:/patients";
	}
	
	
	
	@RequestMapping(value = "/delete-patient/{id}")
	public String deleteTodo(@PathVariable("id") int id) {
		patientService.deletePatientById(id);
		return "redirect:/patients";
	}
	
	@RequestMapping(value = "/patients-search")
	public String serachPatient(@RequestParam("name") String name,ModelMap model) {		
		List<Patient> patients = patientService.searchPatientWithName(name);
		model.put("patients", patients);
		model.put("clicked", 0);
		model.put("size",patients.size());
		return "patients";
	}
}
