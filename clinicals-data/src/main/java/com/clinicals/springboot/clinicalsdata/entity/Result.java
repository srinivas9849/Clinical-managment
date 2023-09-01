package com.clinicals.springboot.clinicalsdata.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
@Component
public class Result {	
	private long id;
	private long patient_id;
	private long compound_id;
	private double val;
	private String desc;
	@FutureOrPresent(message = "please provide valid date")
    @NotNull(message = "please provide valid date")
	private LocalDate date;
	public Result() {super();}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(long patient_id) {
		this.patient_id = patient_id;
	}
	public long getCompound_id() {
		return compound_id;
	}
	public void setCompound_id(long compound_id) {
		this.compound_id = compound_id;
	}
	public double getVal() {
		return val;
	}
	public void setVal(double val) {
		this.val = val;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Result [id=" + id + ", patient_id=" + patient_id + ", compound_id=" + compound_id + ", val=" + val
				+ ", desc=" + desc + ", date=" + date + "]";
	}
	public Result(long id, long patient_id, long compound_id, double val, String desc, LocalDate date) {
		super();
		this.id = id;
		this.patient_id = patient_id;
		this.compound_id = compound_id;
		this.val = val;
		this.desc = desc;
		this.date = date;
	}

	
	

}
