package com.clinicals.springboot.clinicalsdata.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	// @Column(name = "first_name")
	@Size(min = 2, message = "first name should more than 2 characters")
	private String firstName;
	// @Column(name = "last_name")
	@Size(min = 2, message = "Last name should more than 2 characters")
	private String lastName;
	@NotNull
	@FutureOrPresent(message = "please provide valid joined date")
	private LocalDate joinedDate;
	@NotNull
	private String mobile;
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "enter valid email")
	private String email;
	@Size(min = 4, message = "enter valid address")
	private String address;

	public Patient() {
		super();
	}

	public Patient(long id, String firstName, String lastName, LocalDate joinedDate, String mobile, String email,
			String address, List<PatientsComponentResult> results) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.joinedDate = joinedDate;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.results = results;
	}

	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PatientsComponentResult> results = new ArrayList<PatientsComponentResult>();

	public Patient(String firstName, String lastName, LocalDate joinedDate, String mobile, String email, String address,
			List<PatientsComponentResult> results) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.joinedDate = joinedDate;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.results = results;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", joinedDate="
				+ joinedDate + ", mobile=" + mobile + ", email=" + email + ", address=" + address + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(LocalDate joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<PatientsComponentResult> getResults() {
		return results;
	}

	public void setResults(List<PatientsComponentResult> results) {
		this.results = results;
	}

}
