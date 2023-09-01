package com.clinicals.springboot.clinicalsdata.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Column;


@Entity
public class Compound {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	private long id;
	@NotNull(message = "please provide name")
	private String name;
	@Column(name = "des")
	private String desc;
	
	public Compound() {super();}
	
	@OneToMany(mappedBy = "compound", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private List<PatientsComponentResult> results=new ArrayList<PatientsComponentResult>();

	@Override
	public String toString() {
		return "Compound [id=" + id + ", name=" + name + ", desc=" + desc + "]";
	}

	
	public Compound(String name, String desc, List<PatientsComponentResult> results) {
		super();
		this.name = name;
		this.desc = desc;
		this.results = results;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<PatientsComponentResult> getResults() {
		return results;
	}

	public void setResults(List<PatientsComponentResult> results) {
		this.results = results;
	}

}
