package com.jsp.workZone.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.workZone.dao.FloorDao;
import com.jsp.workZone.dto.Floor;
import com.jsp.workZone.exceptionhandlerforworkzone.FloorNotFound;
import com.jsp.workZone.util.ResponseStructure;

@Service
public class FloorService {
	@Autowired
	FloorDao floorDao;

	public ResponseEntity<ResponseStructure<Floor>> fetchById(int id) {
		Floor val = floorDao.fetchByid(id);
		if (val != null) {

			ResponseStructure<Floor> structure = new ResponseStructure<>();
			structure.setData(val);
			structure.setMsg("found floor found ..!");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Floor>>(structure, HttpStatus.FOUND);
		} else {
			throw new FloorNotFound("floor not found");
		}

	}

//	public ResponseEntity<ResponseStructure<Building>> fetchFloorAlongWithBuilding(int id) {
//		 Building val = floorDao.fetchFloorFromBuilding(id);
//		if (val != null) {
//
//			ResponseStructure<Building> structure = new ResponseStructure<>();
//			structure.setData(val);
//			structure.setMsg("found floor found ..!");
//			structure.setStatus(HttpStatus.FOUND.value());
//			return new ResponseEntity<ResponseStructure<Building>>(structure, HttpStatus.FOUND);
//		} else {
//			throw new FloorNotFound("floor not found");
//		}
//
//	}

	
}
