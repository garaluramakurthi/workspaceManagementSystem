package com.jsp.workZone.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.workZone.dto.Client;
import com.jsp.workZone.dto.ClientBooking;
import com.jsp.workZone.dto.WorkSpace;
import com.jsp.workZone.service.ClientBookingService;
import com.jsp.workZone.util.ResponseStructure;

@RestController
public class ClientBookingsController {
	
	@Autowired
	ClientBookingService clientBookingService;
	
	
	
	@PostMapping("/saveClientBooing")
	public ResponseEntity<ResponseStructure<WorkSpace>> BookWorkSpace(@RequestParam int  c_id,@RequestParam int  W_Id,ClientBooking clientBooking) {
		
		return clientBookingService.bookOneWorkSpace(c_id, W_Id, clientBooking);
		
	}

	
	
	
	
	
	
	

}
