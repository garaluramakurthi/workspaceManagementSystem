package com.jsp.workZone.service;

import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.workZone.dao.WorkSpaceDao;
import com.jsp.workZone.dto.Address;
import com.jsp.workZone.dto.Building;
import com.jsp.workZone.dto.Floor;
import com.jsp.workZone.dto.WorkSpace;
import com.jsp.workZone.enums.WorkSpaceType;
import com.jsp.workZone.exceptionhandlerforworkzone.FloorNotFound;
import com.jsp.workZone.exceptionhandlerforworkzone.ManagerNotfound;
import com.jsp.workZone.exceptionhandlerforworkzone.WorkSpaceCapacityNotFound;
import com.jsp.workZone.exceptionhandlerforworkzone.WorkSpaceNotFound;
import com.jsp.workZone.repo.BuildingRepo;
import com.jsp.workZone.repo.FloorRepo;
import com.jsp.workZone.util.ResponseStructure;

@Service
public class WorkSpaceService {

	@Autowired
	private WorkSpaceDao workSpaceDao;

	@Autowired
	private BuildingRepo buildingRepo;
	@Autowired
	private FloorRepo floorRepo;

	// testing
	public ResponseEntity<ResponseStructure<Building>> saveWorkSpaceWithFloors(int managerid, int floorid,
			WorkSpace workSpace) {
		Building dbbuilding = buildingRepo.findManagerById(managerid);
		boolean flag = false;

		if (dbbuilding != null) {
			List<Floor> list = dbbuilding.getFloors();

			for (Floor floor : list) {

				if (floor.getId() == floorid) {
					flag = true;
					floor.getSpaces().add(workSpace);

				}

			}
			if (flag == true) {
				WorkSpace savedWorkspace = workSpaceDao.saveWorkSpace(workSpace);

				if (savedWorkspace != null) {
					ResponseStructure<Building> structure = new ResponseStructure<>();

					structure.setData(dbbuilding);
					structure.setMsg("work Space Saved Sucessfully");
					structure.setStatus(HttpStatus.CREATED.value());
					return new ResponseEntity<ResponseStructure<Building>>(structure, HttpStatus.CREATED);
				} else {
					return null;
				}
			} else {
				throw new FloorNotFound("floor not found");
				// floor not found
			}
		} else {
			throw new ManagerNotfound();
		}

	}

	// testing
	public ResponseEntity<ResponseStructure<List<Building>>> fetchWorkSpaceCapacity(int capacity) {
		List<Building> res = new ArrayList<>();

		List<Building> bdbuilding = buildingRepo.findAll();
		for (Building building : bdbuilding) {
			List<Floor> dbfloors = building.getFloors();
			for (Floor floor : dbfloors) {
				List<WorkSpace> ws = floor.getSpaces();
				for (WorkSpace work : ws) {
					if (work.getCapacity() == capacity) {
						res.add(building);
					}
				}

			}

		}
		if (res.isEmpty()) {
			throw new WorkSpaceNotFound("WorkSpace is not there with capacity");
		} else {
			ResponseStructure<List<Building>> structure = new ResponseStructure<>();
			structure.setMsg("WorkSpace Capacity is Available..!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(res);
			return new ResponseEntity<ResponseStructure<List<Building>>>(structure, HttpStatus.FOUND);

		}

	}

	public ResponseEntity<ResponseStructure<List<Building>>> upadteWorkSpace(WorkSpace workSpace) {
		WorkSpace dbworkspace = workSpaceDao.updateWorkSpace(workSpace);

		List<Building> res = new ArrayList<>();

		List<Building> dbbuilding = buildingRepo.findAll();
		for (Building building : dbbuilding) {
			List<Floor> dbfloors = building.getFloors();
			for (Floor floors : dbfloors) {
				List<WorkSpace> wspaces = floors.getSpaces();
				for (WorkSpace ws : wspaces) {
					if (ws.equals(dbworkspace)) {

						res.add(building);
					}

				}

			}

		}
		if (res.isEmpty()) {
			throw new WorkSpaceNotFound("WorkSpace is not there");

		} else {
			ResponseStructure<List<Building>> structure = new ResponseStructure<>();
			structure.setMsg("WorkSpace updated successfully.");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(res);
			return new ResponseEntity<ResponseStructure<List<Building>>>(structure, HttpStatus.FOUND);

		}
	}

	public ResponseEntity<ResponseStructure<List<Building>>> fetchByid(int id) {
		List<Building> res = new ArrayList<>();
		List<Building> dbbuilding = buildingRepo.findAll();
		for (Building building : dbbuilding) {
			List<Floor> dbfloors = building.getFloors();
			for (Floor f : dbfloors) {
				List<WorkSpace> dbspaces = f.getSpaces();
				for (WorkSpace ws : dbspaces) {
					if (ws.getId() == id) {
						res.add(building);

					}

				}

			}

		}
		if (res.isEmpty()) {
			throw new WorkSpaceNotFound("WorkSpace not found with" + id);

		} else {
			ResponseStructure<List<Building>> structure = new ResponseStructure<>();
			structure.setMsg("workSpace found Sucessfully");
			structure.setData(res);
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Building>>>(structure, HttpStatus.FOUND);

		}

	}

	public ResponseEntity<ResponseStructure<List<Building>>> fetchAll() {
		List<Building> res = buildingRepo.findAll();

		if (res != null) {
			ResponseStructure<List<Building>> structure = new ResponseStructure<>();
			structure.setMsg("workSpace found Sucessfully");
			structure.setData(res);
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Building>>>(structure, HttpStatus.FOUND);
		} else {
			throw new WorkSpaceCapacityNotFound("work space not found ");
		}
	}

	public ResponseEntity<ResponseStructure<List<Building>>> fetchByType(WorkSpaceType spaceType) {
		List<Building> dbbuiding = buildingRepo.findAll();

		List<Building> res = new ArrayList<>();
		for (Building building : dbbuiding) {
			List<Floor> dbfloors = building.getFloors();
			for (Floor floors : dbfloors) {
				List<WorkSpace> dbspaces = floors.getSpaces();
				for (WorkSpace ws : dbspaces) {
					if (ws.getSpaceType().equals(spaceType)) {
						res.add(building);
					}

				}

			}

		}
		if (res.isEmpty()) {
			throw new WorkSpaceNotFound("WorkSpace is not there with that type");
		} else {
			ResponseStructure<List<Building>> structure = new ResponseStructure<>();
			structure.setMsg("WorkSpace type is Available..!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(res);
			return new ResponseEntity<ResponseStructure<List<Building>>>(structure, HttpStatus.FOUND);

		}

	}

	public ResponseEntity<ResponseStructure<List<Building>>> fetchWorkSpaceCost(double cost) {

		// List<WorkSpace> costList = workSpaceDao.fetchWorkSpaceCost(cost);
		List<Building> res = new ArrayList<>();

		boolean flag = false;

		List<Building> listbuilding = buildingRepo.findAll();

		for (Building building : listbuilding) {
			List<Floor> lifloors = building.getFloors();
			for (Floor floor : lifloors) {
				List<WorkSpace> ws = floor.getSpaces();
				for (WorkSpace worksp : ws) {
					if (worksp.getCost() == cost) {

						res.add(building);
						flag = true;

					}
				}

			}

		}
		if (res.isEmpty()) {
			throw new WorkSpaceNotFound("WorkSpace is not there with cost ");

		} else {
			ResponseStructure<List<Building>> structure = new ResponseStructure<>();
			structure.setMsg("WorkSpace cost is Available..!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(res);
			return new ResponseEntity<ResponseStructure<List<Building>>>(structure, HttpStatus.FOUND);

		}

	}

	public ResponseEntity<ResponseStructure<List<Building>>> fetchWorkSpaceLocation(String city) {

		List<Building> res = new ArrayList<>();

		List<Building> listbuilding = buildingRepo.findAll();

		for (Building building : listbuilding) {
			List<Floor> dbfloors = building.getFloors();
			for (Floor floors : dbfloors) {
				List<WorkSpace> spaces = floors.getSpaces();
				for (WorkSpace ws : spaces) {
					if (ws.getAvailability().equals("yes")) {

						Address dbaddress = building.getAddress();
						if (dbaddress != null) {
							if (dbaddress.getCity().equalsIgnoreCase(city)) {

								res.add(building);
							}
						}

					}

				}

			}

		}
		if (res.isEmpty()) {
			throw new WorkSpaceNotFound("WorkSpace is  Availabile ");

		} else {
			ResponseStructure<List<Building>> structure = new ResponseStructure<>();
			structure.setMsg("WorkSpace city is Available..!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(res);
			return new ResponseEntity<ResponseStructure<List<Building>>>(structure, HttpStatus.FOUND);

		}

	}
	public ResponseEntity<ResponseStructure<WorkSpace>> deleteWorkSpace(int id) {
	WorkSpace res = workSpaceDao.deleteById(id);
	if(res!=null) {
		
		ResponseStructure<WorkSpace> structure = new ResponseStructure<>();
		structure.setMsg("WorkSpace is Deleted..!");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(res);
		return new ResponseEntity<ResponseStructure<WorkSpace>>(HttpStatus.FOUND);
	}
	else {
		return null;
	}


		
		}


	

}
