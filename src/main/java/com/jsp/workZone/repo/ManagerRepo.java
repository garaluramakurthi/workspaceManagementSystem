package com.jsp.workZone.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.workZone.dto.Manager;

public interface ManagerRepo extends JpaRepository<Manager, Integer> {
	@Query("Select a From Manager a where name=?1 ")
	public List<Manager> findManagerByName(String name );
	
	@Query("Select a From Manager a where experience=?1 ")
	public List<Manager> findManagerByExperience(int experience );
	
	
	@Query("Select a From Manager a where email=?1")
	public Manager fetchManger(String email);


}
