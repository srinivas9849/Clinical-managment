package com.clinicals.springboot.clinicalsdata.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinicals.springboot.clinicalsdata.entity.Compound;
import com.clinicals.springboot.clinicalsdata.entity.Patient;
import com.clinicals.springboot.clinicalsdata.service.CompoundService;

@Controller
public class CompoundController {
	
	@Autowired
	private CompoundService compoundService;
	
	@RequestMapping(value = "/compounds",method = RequestMethod.GET)	
	public String showAllCompounds(ModelMap model) {
		List<Compound> compounds = compoundService.getCompounds();
		model.put("compounds", compounds);
		model.put("clicked", 1);
		model.put("size", compounds.size());

		return "compound";
		
	}
	
	@RequestMapping(value="/add-compound",method = RequestMethod.GET)
	public String showAddPatientPage(@ModelAttribute("compound") Compound compound,ModelMap model) {		
		return "add-compound";
	}
	
	
	@RequestMapping(value="/add-compound",method = RequestMethod.POST)
	public String addTodo( @ModelAttribute("compound") Compound compound) {
		
		
		compoundService.addCompound(compound);
		return "redirect:/compounds";
	}
	
	
	@RequestMapping(value = "/update-compound")
	public String ShowUpdateTodoPage(@RequestParam("id") int id,ModelMap model) {
		Compound compound=compoundService.getCompoundById(id);
		model.put("compound",compound);
		return "update-compound";
	}
	
	
	@RequestMapping(value="/update-compound",method = RequestMethod.POST)
	public String updateTodo(@ModelAttribute("compound") Compound compound) {
		
		compoundService.updateTodo(compound);
		return "redirect:/compounds";
	}
	@RequestMapping(value = "/delete-compound/{id}")
	public String deleteTodo(@PathVariable("id") int id) {
		compoundService.deleteCompoundById(id);
		return "redirect:/compounds";
	}
	
	@RequestMapping(value = "/compound-search")
	public String serachPatient(@RequestParam("name") String name,ModelMap model) {		
		List<Compound> compounds =  compoundService.searchTestWithName(name);
		model.put("compounds", compounds);
		model.put("clicked", 1);
		model.put("size", compounds.size());

		return "compound";
	}
	
	
	
	
	

}
