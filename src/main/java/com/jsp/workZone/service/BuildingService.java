package com.jsp.workZone.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.workZone.dao.AdminDao;
import com.jsp.workZone.dao.BuildingDao;
import com.jsp.workZone.dao.ManagerDao;
import com.jsp.workZone.dto.Admin;
import com.jsp.workZone.dto.Building;
import com.jsp.workZone.dto.Manager;
import com.jsp.workZone.exceptionhandlerforworkzone.AdminNotFound;
import com.jsp.workZone.exceptionhandlerforworkzone.BuildingNotfound;
import com.jsp.workZone.exceptionhandlerforworkzone.ManagerAlreadyAssignAnotherBuilding;
import com.jsp.workZone.exceptionhandlerforworkzone.ManagerNotfound;
import com.jsp.workZone.util.ResponseStructure;

@Service
public class BuildingService {

	@Autowired
	private BuildingDao buildingDao;

	@Autowired
	private AdminDao adminDao;
	@Autowired
	private ManagerDao managerDao;

	/*
	 * javacode
	 * 
	 * we are saving the the date
	 * 
	 * 
	 * 
	 */

	public ResponseEntity<ResponseStructure<Building>> saveBuilding(Building building, int AdminId) {

		Admin dbAdmin = adminDao.findAdminById(AdminId);

		if (dbAdmin != null) {
			

			// newly added
			Building dbbuilding1 = buildingDao.saveBuilding(building);

			dbbuilding1.setAdmin(dbAdmin);

			Building dbbuilding = buildingDao.saveBuilding(building);

			// newly added code ended

			ResponseStructure<Building> structure = new ResponseStructure<>();
			structure.setData(dbbuilding);
			structure.setMsg("Building Saved Successfully.");
			structure.setStatus(HttpStatus.CREATED.value());

			return new ResponseEntity<ResponseStructure<Building>>(structure, HttpStatus.CREATED);

		}

		throw new AdminNotFound();

	}

	public ResponseEntity<ResponseStructure<List<Building>>> findBuildingByName(String buildingName) {

		List<Building> dbbuilding = buildingDao.fetchBuildingByName(buildingName);
		if (dbbuilding != null) {
			ResponseStructure<List<Building>> structure = new ResponseStructure<>();
			structure.setData(dbbuilding);
			structure.setMsg("building found successfully.");
			structure.setStatus(HttpStatus.FOUND.value());

			return new ResponseEntity<ResponseStructure<List<Building>>>(structure, HttpStatus.FOUND);
		} else {

			throw new BuildingNotfound();
		}
	}

	
	
	public ResponseEntity<ResponseStructure<List<Building>>> findBuildingByAddress(String city) {
		List<Building> dbbuBuildings = buildingDao.findBuildingByAddress(city);
		if (dbbuBuildings != null) {
			ResponseStructure<List<Building>> structure = new ResponseStructure<>();
			structure.setData(dbbuBuildings);
			structure.setMsg("building found in the city successfully.");
			structure.setStatus(HttpStatus.FOUND.value());

			return new ResponseEntity<ResponseStructure<List<Building>>>(structure, HttpStatus.FOUND);
		} else {
			throw new BuildingNotfound("Building not found in " + city + " Try with another one!");
		}
	}
	
	
	/*
	 * Admin  can Assign manager  to building
	 * 
	 * 
	 */
	

	public ResponseEntity<ResponseStructure<Building>> assignManagerToBuilding(int buildingId, int managerId,int adminId) {

		Admin admin = adminDao.findAdminById(adminId);

		if (admin != null) {

			Manager manager = managerDao.findManagerById(managerId);

			if (manager != null) {

				Building building = buildingDao.findBuildingById(buildingId);

				if (building != null) {
					
					// newly added line
					
					if(buildingDao.findManagerById(managerId)==null) {

					building.setManager(manager);
					
					/*––
					 * setting is manager  
					 * 
					 */
					Building managerAdded = buildingDao.saveBuilding(building);

					// newly added line completed

					ResponseStructure<Building> structure = new ResponseStructure<>();
					structure.setMsg("manager assigned to the building");
					structure.setStatus(HttpStatus.ACCEPTED.value());
					structure.setData(managerAdded);

					return new ResponseEntity<ResponseStructure<Building>>(structure, HttpStatus.ACCEPTED);
					}
					else {
						throw new ManagerAlreadyAssignAnotherBuilding("Manager is Already Assingen to another Building");
					}

				} else {
					throw new BuildingNotfound("Building is not there to assign manager!");
				}

			} else {
				throw new ManagerNotfound("Manager is not there to assign it to building");
			}

		} else {
			throw new AdminNotFound("Admin not found to assign it to building! ");
		}
	}
	
	public ResponseEntity<ResponseStructure<Building>> findBuildingById(int id){
		
		Building dbbuilding = buildingDao.findBuildingById(id);
		if(dbbuilding!=null) { 
			ResponseStructure<Building> structure=new ResponseStructure<Building>();
			structure.setMsg("building id "+id+" found successfully.");
			structure.setData(dbbuilding);
			structure.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStructure<Building>> (structure,HttpStatus.FOUND);
		}
		else {
			throw new BuildingNotfound();
		}
		
	
	}
	public ResponseEntity<ResponseStructure<List<Building>>> fetchAllBuildings(){
		
		List<Building> listofBuildings = buildingDao.fetchAllBuildings();
		if(listofBuildings!=null) {
			
			ResponseStructure<List<Building>> structure=new ResponseStructure<>();
			structure.setMsg("Buildings found successfully");
			structure.setData(listofBuildings);
			structure.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStructure<List<Building>>> (structure,HttpStatus.FOUND);
		}
		else {
			throw new BuildingNotfound();	
		}
		
	}
	public ResponseEntity<ResponseStructure<Building>> updateBuilding(Building building){
		
		
		Building dbbuilding = buildingDao.updateBuilding(building);
		if(dbbuilding!=null) {
			ResponseStructure<Building> structure=new ResponseStructure<>();
			structure.setMsg("building id"+building.getId()+"updated successfully");
			structure.setData(dbbuilding);
			return new ResponseEntity<ResponseStructure<Building>>(structure,HttpStatus.FOUND);
			
		}
		else {
			throw new BuildingNotfound();
		}
	}
	public ResponseEntity<ResponseStructure<Building>> deleteById(int id){
		
		Building dbbuilding = buildingDao.deleteBuilding(id);
		if(dbbuilding!=null) {
			ResponseStructure<Building> structure=new ResponseStructure<>();
			structure.setMsg("building id"+id+"deleted successfully");
			structure.setData(dbbuilding);
			structure.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStructure<Building>>(structure,HttpStatus.FOUND);	
		}
		else {
			throw new BuildingNotfound();
		}

		
	}

}
