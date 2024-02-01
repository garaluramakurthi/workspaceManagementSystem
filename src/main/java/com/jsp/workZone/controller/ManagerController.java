package com.jsp.workZone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.workZone.dto.Manager;
import com.jsp.workZone.service.ManagerService;
import com.jsp.workZone.util.ResponseStructure;

@RestController
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	@PostMapping("/saveManager")
	public ResponseEntity<ResponseStructure<Manager>> saveManager(@RequestBody Manager manager) {
		return managerService.saveManager(manager);
	}

	@GetMapping("/findmanagerbyid")
	public ResponseEntity<ResponseStructure<Manager>> findManagerById(@RequestParam int id) {
		return managerService.fetchById(id);
	}

	@GetMapping("/findmanagerByname")
	public ResponseEntity<ResponseStructure<List<Manager>>> findManagerByName(@RequestParam String name) {
		return managerService.findManagerdByName(name);
	}

	@PutMapping("/updatemanagerdetails")
	public ResponseEntity<ResponseStructure<Manager>> updateManager(@RequestBody Manager manager) {
		return managerService.updateManager(manager);
	}
	
	@GetMapping("/findManagerByExperience")
	public ResponseEntity<ResponseStructure<List<Manager>>> findManagerByExperience(@RequestParam int experience) {
		return managerService.findManagerByExperience(experience);
	}
	
	@DeleteMapping("/deleteMangerById")
	public ResponseEntity<ResponseStructure<Manager>> deleteMangerById(@RequestParam int id) {
		return managerService.deleteManagerById(id);
	}

	@GetMapping("/loginManager")
	public ResponseEntity<ResponseStructure<Manager>>loginManager(@RequestParam String email,@RequestParam String password) {
		return managerService.loginManager(email, password);
	}

}
