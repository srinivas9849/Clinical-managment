package com.clinicals.springboot.clinicalsdata.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.clinicals.springboot.clinicalsdata.entity.Compound;

public interface CompoundRepo extends JpaRepository<Compound,Long> {
	@Query(value="select * from Compound u where u.name like %:name% order by name", nativeQuery=true)
	public List<Compound> searchTest(@Param("name") String name);
	

}

