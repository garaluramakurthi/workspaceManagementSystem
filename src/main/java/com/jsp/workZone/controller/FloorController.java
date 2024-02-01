package com.jsp.workZone.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.workZone.dto.Floor;
import com.jsp.workZone.service.FloorService;
import com.jsp.workZone.util.ResponseStructure;

@RestController
public class FloorController {
	
	
	@Autowired
	FloorService floorService;
	
	@GetMapping("/fetchfloorById")
	public ResponseEntity<ResponseStructure<Floor>> fetcById(int id){
		return floorService.fetchById(id);
		
	}
//	@GetMapping("fetchFloorAlongWithBuilding")
//	public ResponseEntity<ResponseStructure<Building>> fetcFloorAlongWithBuilding(int id){
//		return floorService.fetchFloorAlongWithBuilding(id);
//		
//	}

}
