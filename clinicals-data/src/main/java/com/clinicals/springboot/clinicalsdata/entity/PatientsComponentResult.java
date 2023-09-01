package com.clinicals.springboot.clinicalsdata.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

@Entity
public class PatientsComponentResult {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	

	public PatientsComponentResult(){super();}
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "compound_id", nullable = false)
	@JsonIgnore
	private Compound compound;
	
	
	public PatientsComponentResult(Compound compound, Patient patient, double val, String desc, LocalDate date) {
		super();
		this.compound = compound;
		this.patient = patient;
		this.val = val;
		this.desc = desc;
		this.date = date;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
	@JsonIgnore
	private Patient patient;
	private double val;
	@Column(name = "des")
	private String desc;
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setVal(double val) {
		this.val = val;
	}

    
	private LocalDate date;
	@Override
	public String toString() {
		return "PatientsComponentResult [id=" + id + ", compound=" + compound + ", patient=" + patient + ", val=" + val
				+ ", desc=" + desc + ", date=" + date + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Compound getCompound() {
		return compound;
	}
	public void setCompound(Compound compound) {
		this.compound = compound;
	}
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public double getVal() {
		return val;
	}
	public void setValue(double val) {
		this.val = val;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

}
