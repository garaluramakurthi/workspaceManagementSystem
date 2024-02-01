package com.jsp.workZone.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.workZone.dto.Admin;
import com.jsp.workZone.service.AdminService;
import com.jsp.workZone.util.ResponseStructure;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@CrossOrigin("http://127.0.0.1:5500")
	@PostMapping("/saveadmin")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) {
		
		return adminService.saveAdmin(admin);
		
	}
	@CrossOrigin("http://127.0.0.1:5500")
	@GetMapping("/findadminbyid")
	public ResponseEntity<ResponseStructure<Admin>> findAdminById(@RequestParam int id){
		return adminService.findAdminById(id);
	}
	
	@GetMapping("/findadminbyName")
	public ResponseEntity<ResponseStructure <List<Admin> >> findAdminByName(@RequestParam String AdminName){
		
		
		return adminService.findAdmindByName(AdminName);
	}

	@DeleteMapping("/deleteadminbyid")
	public ResponseEntity<ResponseStructure<Admin>> deleteAdminById(@RequestParam int Adminid){
		return adminService.deleteAdminById(Adminid);
	}
	
	@PutMapping("/updateAdmin")
	public ResponseEntity<ResponseStructure<Admin>> UpdateAdmin(@RequestBody Admin admin){
		return adminService.updateAdmin(admin);
	}
	

	
	@PutMapping("/updateAdminAlongWithAdress")
	public ResponseEntity<ResponseStructure<Admin>> UpdateAdminAlongWithAdress(@RequestBody Admin admin){
		return adminService.updateAdminAlongAdress(admin);
	}

	
	@GetMapping("/loginAdmin")
	public ResponseEntity<ResponseStructure<Admin > >loginAdmin(@RequestParam String email,@RequestParam String Password){
		
		
		return adminService.login(email, Password);
	}



}
