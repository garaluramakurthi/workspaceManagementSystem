package com.jsp.workZone.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.workZone.dto.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{
	
	@Query("Select a From Admin a where name=?1 ")
	public List<Admin> findAdminByName(String name);
	
	
	@Query("Select a From Admin a where email=?1 ")
	public Admin findAdminByEmail(String email);
	

}
