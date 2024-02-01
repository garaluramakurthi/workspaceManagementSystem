package com.jsp.workZone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.workZone.dao.AddressDao;
import com.jsp.workZone.dto.Address;
import com.jsp.workZone.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;
	
	
	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address){
		Address dbAdress = addressDao.updateAdress(address);
		if(dbAdress!=null) {
			ResponseStructure<Address> structure=new ResponseStructure<>();
			structure.setData(dbAdress);
			structure.setMsg("Adress Updated Sucessfully");
			structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
			
		}
		else {
			return null;
		}
		
		
	}

}
