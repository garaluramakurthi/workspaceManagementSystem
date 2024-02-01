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

import com.jsp.workZone.dto.Building;
import com.jsp.workZone.service.BuildingService;
import com.jsp.workZone.util.ResponseStructure;

@RestController
public class BuildingController {

	@Autowired
	private BuildingService buildingService;

	@PostMapping("/savebuilding")
	public ResponseEntity<ResponseStructure<Building>> saveBuilding(@RequestBody Building building,@RequestParam int adminId) {
		return buildingService.saveBuilding(building, adminId);
	}
	
	@GetMapping("findbuildingById")
	public ResponseEntity<ResponseStructure<Building>> findBuildingById(@RequestParam int id){
		
		return buildingService.findBuildingById(id);
		
		
	}

	@GetMapping("/findbuildingByname")
	public ResponseEntity<ResponseStructure<List<Building>>> findBuildingById(@RequestParam String buildingname) {
		return buildingService.findBuildingByName(buildingname);
	}

	@GetMapping("/findBuildingByCity")
	public ResponseEntity<ResponseStructure<List<Building>>> findBuildingByAddress(@RequestParam String city){
		return buildingService.findBuildingByAddress(city);
	}
	
	/*
	 * Assigning Manager to Building which can be by Admin only.
	 */

	@PutMapping("/assignmanagertobuilding")
	public ResponseEntity<ResponseStructure<Building>> assignManagerToBuilding(@RequestParam int buildingId,@RequestParam int managerId,@RequestParam int adminId){
		return buildingService.assignManagerToBuilding(buildingId, managerId, adminId);
	}
	@GetMapping("/fetchAllBuildings")
	public ResponseEntity<ResponseStructure<List<Building>>> fetchAllBuildings(){
		return buildingService.fetchAllBuildings();
	}
	@PutMapping("/updateBuilding")
	public ResponseEntity<ResponseStructure<Building>> updateBuilding(@RequestBody Building building){
		
	return	buildingService.updateBuilding(building);
	}
	@DeleteMapping("/deleteBuilding")
	public ResponseEntity<ResponseStructure<Building>> deleteBuilding(@RequestParam int bulidingid){
		
		return buildingService.deleteById(bulidingid);
		
	}
	
}
