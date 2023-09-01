package com.clinicals.springboot.clinicalsdata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.clinicals.springboot.clinicalsdata.entity.Compound;
import com.clinicals.springboot.clinicalsdata.repo.CompoundRepo;

@Service
public class CompoundService {
	
	@Autowired
	private CompoundRepo compoundRepo;

	
	
	public List<Compound> getCompounds(){
		
		return (List<Compound>) compoundRepo.findAll(Sort.by(Order.by("id")));
	}
	public Compound getCompoundById(long id) {
		Optional<Compound> findById = compoundRepo.findById(id);
		return findById.get();
		
	}
	public void addCompound(Compound compound) {
		compoundRepo.save(compound);
	}
	public void deleteCompoundById(long id) {
		compoundRepo.deleteById(id);
	}
	public void updateTodo(Compound compound) {
		compoundRepo.save(compound);
	
	}
	public List<Compound> searchTestWithName(String name) {
		return compoundRepo.searchTest(name);
		
	}
	
	

}
