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
import com.jsp.workZone.dto.Manager;
import com.jsp.workZone.exceptionhandlerforworkzone.ManagerNotfound;
import com.jsp.workZone.exceptionhandlerforworkzone.WorngEmail;
import com.jsp.workZone.exceptionhandlerforworkzone.WrongPassword;
import com.jsp.workZone.util.ResponseStructure;

@Service
public class ManagerService {

	@Autowired
	private ManagerDao managerDao;

	public ResponseEntity<ResponseStructure<Manager>> saveManager(Manager manager) {
		Manager dbManager = managerDao.saveManager(manager);
		ResponseStructure<Manager> structure = new ResponseStructure<Manager>();
		structure.setData(dbManager);
		structure.setMsg("Manager Saved successfully...");
		structure.setStatus(HttpStatus.CREATED.value());

		return new ResponseEntity<ResponseStructure<Manager>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Manager>> fetchById(int id) {
		Manager dbManager = managerDao.findManagerById(id);

		if (dbManager != null) {
			ResponseStructure<Manager> structure = new ResponseStructure<>();
			structure.setMsg("Manager id " + id + " found successfully.");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbManager);

			return new ResponseEntity<ResponseStructure<Manager>>(structure, HttpStatus.FOUND);
		} else {
			throw new ManagerNotfound("manager not found...!");

		}

	}

	public ResponseEntity<ResponseStructure<List<Manager>>> findManagerdByName(String name) {

		List<Manager> dbManager = managerDao.findManagerByName(name);

		if (dbManager != null) {
			ResponseStructure<List<Manager>> structure = new ResponseStructure<>();
			structure.setMsg("Manager Name " + name + " found successfully.");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbManager);

			return new ResponseEntity<ResponseStructure<List<Manager>>>(structure, HttpStatus.FOUND);

		} else {
			throw new ManagerNotfound("Manager is not ther with name " + name);
		}

	}

	public ResponseEntity<ResponseStructure<Manager>> updateManager(Manager manager) {
		Manager dbmanager = managerDao.updateManager(manager);
		if (dbmanager != null) {
			ResponseStructure<Manager> structure = new ResponseStructure<>();
			structure.setMsg("manager updated successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbmanager);
			return new ResponseEntity<ResponseStructure<Manager>>(structure, HttpStatus.FOUND);
		} else {
			throw new ManagerNotfound("manager is not found with this id " + manager.getId());
		}
	}

	public ResponseEntity<ResponseStructure<List<Manager>>> findManagerByExperience(int experience) {

		List<Manager> dbManager = managerDao.findManagerExperience(experience);

		if (dbManager != null) {
			ResponseStructure<List<Manager>> structure = new ResponseStructure<>();
			structure.setMsg("Managers with " + experience + " found successfully.");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbManager);

			return new ResponseEntity<ResponseStructure<List<Manager>>>(structure, HttpStatus.FOUND);

		} else {
			throw new ManagerNotfound("Manager is not ther with experienc " + experience);
		}

	}

	public ResponseEntity<ResponseStructure<Manager>> deleteManagerById(int id) {
		Manager dbManager = managerDao.deleteManagerById(id);

		if (dbManager != null) {
			ResponseStructure<Manager> structure = new ResponseStructure<>();
			structure.setMsg("Manager id " + id + " found successfully.");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbManager);

			return new ResponseEntity<ResponseStructure<Manager>>(structure, HttpStatus.FOUND);
		} else {
			throw new ManagerNotfound("manager not found...!");

		}

	}

	public ResponseEntity<ResponseStructure<Manager>> loginManager(String email, String pwd) {
		Manager dbManager = managerDao.findManagerByEmail(email);

		
			if (dbManager.getEmail().equals(email)) {
				if (dbManager.getPwd().equals(pwd)) {
					ResponseStructure<Manager> structure = new ResponseStructure<>();
					structure.setMsg("Manager found successfully.");
					structure.setStatus(HttpStatus.FOUND.value());
					structure.setData(dbManager);

					return new ResponseEntity<ResponseStructure<Manager>>(structure, HttpStatus.FOUND);
				} else {
					throw new WrongPassword("incorect password....!");
				}

			} else {
				throw new WorngEmail("incorrect email....!");

			}

		} 

		

	

}
