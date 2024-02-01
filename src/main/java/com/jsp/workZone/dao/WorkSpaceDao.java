package com.jsp.workZone.dao;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.workZone.dto.Building;
import com.jsp.workZone.dto.Floor;
import com.jsp.workZone.dto.WorkSpace;
import com.jsp.workZone.enums.WorkSpaceType;
import com.jsp.workZone.repo.FloorRepo;
import com.jsp.workZone.repo.WorkspaceRepo;

@Repository
public class WorkSpaceDao {

	@Autowired
	private WorkspaceRepo workspaceRepo;
	@Autowired
	private FloorRepo floorRepo;

	public WorkSpace saveWorkSpace(WorkSpace workSpace) {

		return workspaceRepo.save(workSpace);

	}

	public List<Building> fetchWorkSpaceCapacity(int capacity) {
		List<Building> val = workspaceRepo.fetchWorkSpaceCapacity(capacity);
		if (val.isEmpty()) {
			return null;
		} else {

			return val;
		}

	}

	public WorkSpace updateWorkSpace(WorkSpace workSpace) {

		WorkSpace dbworkspace = workspaceRepo.findById(workSpace.getId()).get();
		if (dbworkspace != null) {

			if (workSpace.getAvailability() != null) {
				dbworkspace.setAvailability(workSpace.getAvailability());
			}
			if (workSpace.getCapacity() != 0) {
				dbworkspace.setCapacity(workSpace.getCapacity());
			}
			if (workSpace.getCost() != 0) {
				dbworkspace.setCost(workSpace.getCost());
			}
			if (workSpace.getPricePerDay() != 0) {
				dbworkspace.setPricePerDay(workSpace.getPricePerDay());

			}
			if (workSpace.getSpaceType() != null) {
				dbworkspace.setSpaceType(workSpace.getSpaceType());
			}
			if (workSpace.getCost() != 0) {
				dbworkspace.setCost(workSpace.getCost());

			}
			if (workSpace.getSquareFeet() !=null) {
				dbworkspace.setSquareFeet(workSpace.getSquareFeet());

			}
			if (workSpace.getClients() !=null) {
				dbworkspace.setClients(workSpace.getClients());

			}
	
			WorkSpace finalres = workspaceRepo.save(dbworkspace);
			return finalres;
		} else {
			return null;
		}
	}

	public WorkSpace fetchById(int id) {
		if(workspaceRepo.findById(id).isPresent()) {
			WorkSpace val = workspaceRepo.findById(id).get();
			return val;
		}
		else {
			return null;
		}

	}

	public List<WorkSpace> fetchAll() {
		List<WorkSpace> val = workspaceRepo.findAll();
		if (val != null) {
			return val;
		} else {
			return null;
		}
	}

	public List<WorkSpace> fetchBytype(WorkSpaceType spaceType) {
		List<WorkSpace> wS = workspaceRepo.fetchByType(spaceType);

		if (wS != null) {
			return wS;
		} else {
			return null;
		}
	}
	
	
	public List<WorkSpace> fetchWorkSpaceCost(double cost) {
		List<WorkSpace> val = workspaceRepo.fetchByCost(cost);
		if (val.isEmpty()) {
			return null;
		} else {

			return val;
		}

	}
	public WorkSpace deleteById(int id) {
		Optional<WorkSpace> val = workspaceRepo.findById(id);
		if(workspaceRepo.findById(id).isPresent()) {
			List<Floor> dbfloors = floorRepo.findAll();
		List<WorkSpace> li=new ArrayList<>();
			for (Floor floor : dbfloors) {
				List<WorkSpace> wslist = floor.getSpaces();
				for (WorkSpace ws : wslist) {
					if(ws.getId()==id) {

						floor.setSpaces(null);
						workspaceRepo.deleteById(ws.getId());
						
					}
					else {
						li.add(ws);
						
					}
					
					
				}
				
			}
		
			return  val.get();
		}
		else {
			return null;
		}

	}

	


}
