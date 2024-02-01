package com.jsp.workZone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.workZone.dto.Address;
import com.jsp.workZone.service.AddressService;
import com.jsp.workZone.util.ResponseStructure;

@RestController
public class AddressConroller {
	@Autowired
	AddressService addressService;
	@PutMapping("/updateAdress")
	ResponseEntity<ResponseStructure<Address>> updateAdress(Address address){
		return  addressService.updateAddress(address);
		
	}

}
