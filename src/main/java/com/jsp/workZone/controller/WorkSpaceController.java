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
import com.jsp.workZone.dto.WorkSpace;
import com.jsp.workZone.enums.WorkSpaceType;
import com.jsp.workZone.service.WorkSpaceService;
import com.jsp.workZone.util.ResponseStructure;

@RestController
public class WorkSpaceController {
	
	
	@Autowired
	WorkSpaceService spaceService;
	
	@PostMapping("/saveWorkSpace")
	public ResponseEntity<ResponseStructure<Building>> saveWorkSpace(@RequestParam int managerid, @RequestParam int floorid,@RequestBody WorkSpace workSpace){
		return spaceService.saveWorkSpaceWithFloors(managerid, floorid, workSpace);
		
	}
	
	@GetMapping("/fetchByCapacity")
	public ResponseEntity<ResponseStructure<List<Building>>> fetchCapacity(@RequestParam int capacity){
		return spaceService.fetchWorkSpaceCapacity(capacity);
		
	}
	
	@PutMapping("updateWorkSpace")
	public ResponseEntity<ResponseStructure<List<Building>>> updateWorkSpace(@RequestBody WorkSpace workSpace){
		return spaceService.upadteWorkSpace(workSpace);
		
	}

	@GetMapping("/fetchAll")
	public ResponseEntity<ResponseStructure<List<Building>>> fetchAllWorkSpaces(){
		return spaceService.fetchAll();
		
	}
	@GetMapping("/findByid")
	public ResponseEntity<ResponseStructure<List<Building>>> fetchByid(@RequestParam int id){
		
		return spaceService.fetchByid(id);
		
	}

	@GetMapping("/fetchType")
	public ResponseEntity<ResponseStructure<List<Building>>> fetchType(@RequestParam WorkSpaceType type){
		return spaceService.fetchByType(type);
		
	}
	@GetMapping("/fetchByCost")
	public ResponseEntity<ResponseStructure<List<Building>>> fetchCost(@RequestParam double cost){
		return spaceService.fetchWorkSpaceCost(cost);
		
	}
	@GetMapping("/fetchByCity")
	public ResponseEntity<ResponseStructure<List<Building>>> fetchCity(@RequestParam String city){
		return spaceService.fetchWorkSpaceLocation(city);
		
	}
	@DeleteMapping("/deleteById")
	public ResponseEntity<ResponseStructure<WorkSpace>> deleteById(@RequestParam int id){
		return spaceService.deleteWorkSpace(id);
		
	}



	
	

}
