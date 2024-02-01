package com.jsp.workZone.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jsp.workZone.dto.Floor;
import com.jsp.workZone.repo.FloorRepo;
@Repository
public class FloorDao {
	@Autowired
	FloorRepo floorRepo;
	

	public Floor fetchByid(int id) {
		
		if(floorRepo.findById(id).isPresent()) {
			Floor val = floorRepo.findById(id).get();
			return val;
		}
		else {
			return  null;
		}
		
		
	}
	
//	public Building fetchFloorFromBuilding(int id) {
//		Building res = floorRepo.fetchFloorFromBuilding(id);
//		if(res!=null) {
//			return res;
//			
//		}
//		else {
//			return null;
//		}
//		
//	}
	
}
