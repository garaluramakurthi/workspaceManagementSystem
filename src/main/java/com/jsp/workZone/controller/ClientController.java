package com.jsp.workZone.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.workZone.dto.Client;
import com.jsp.workZone.service.ClientService;
import com.jsp.workZone.util.ResponseStructure;

@RestController
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping("/saveClient")
	public ResponseEntity<ResponseStructure<Client>> saveClient(@RequestBody Client client) {
		return clientService.saveClient(client);
	}
	
	@GetMapping("/loginClient")
	public ResponseEntity<ResponseStructure<Client>> loginClient(@RequestParam String email,@RequestParam String  password) {
		return clientService.loginClient(email, password);
	}
	@GetMapping("/fetchClientById")
	public ResponseEntity<ResponseStructure<Client>> fetchByid(@RequestParam int id){
		return clientService.findByid(id);
		
	}
	@PutMapping("updateClient")
	public ResponseEntity<ResponseStructure<Client>> updateClient(@RequestBody Client client){
		return clientService.updateClient(client);
	}

}
