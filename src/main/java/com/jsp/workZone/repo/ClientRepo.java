package com.jsp.workZone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.workZone.dto.Client;

public interface ClientRepo extends JpaRepository<Client, Integer>{
	
	@Query("Select a from Client a Where email=?1")
	public Client fetchByEmail(String email);
		
	

}
