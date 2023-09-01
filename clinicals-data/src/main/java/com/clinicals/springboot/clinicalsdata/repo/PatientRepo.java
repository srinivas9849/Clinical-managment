package com.clinicals.springboot.clinicalsdata.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.clinicals.springboot.clinicalsdata.entity.Patient;

public interface PatientRepo extends JpaRepository<Patient,Long> {
	 
	@Query(value="select * from Patient u where u.first_name like %:name% or u.last_name like %:name% order by first_name,last_name", nativeQuery=true)
	public List<Patient> searchPatient(@Param("name") String name);
	

}

