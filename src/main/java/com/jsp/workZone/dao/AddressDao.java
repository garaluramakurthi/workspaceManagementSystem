package com.jsp.workZone.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.workZone.dto.Address;
import com.jsp.workZone.repo.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	AddressRepo addressRepo;

	public Address updateAdress(Address address) {

		Address address1 = addressRepo.findById(address.getId()).get();

		if (address1 != null) {
			if (address.getCity() != null) {
				address1.setCity(address.getCity());
			}
			if (address.getDistrict() != null) {
				address1.setDistrict(address.getDistrict());
			}
			if (address.getDoor_No() != null) {
				address1.setDoor_No(address.getDoor_No());
			}
			if (address.getLandmark() != null) {
				address1.setLandmark(address.getLandmark());
			}
			if (address.getPincode() != 0) {
				address1.setPincode(address.getPincode());
			}
			if (address.getState() != null) {
				address1.setState(address.getState());
			}
			if (address.getStreet() != null) {
				address1.setStreet(address.getStreet());
			}
			addressRepo.save(address1);
			return address1;
		} else {
			return null;
		}

	}

	public Address findByid(int id) {
		Address dbaddress = addressRepo.findById(id).get();
		if (dbaddress != null) {
			return dbaddress;

		} else {
			return null;
		}

	}

}
