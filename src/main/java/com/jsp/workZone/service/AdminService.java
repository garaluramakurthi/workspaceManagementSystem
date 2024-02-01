package com.jsp.workZone.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.workZone.dao.AdminDao;
import com.jsp.workZone.dto.Admin;
import com.jsp.workZone.exceptionhandlerforworkzone.AdminNotFound;
import com.jsp.workZone.exceptionhandlerforworkzone.WorngEmail;
import com.jsp.workZone.exceptionhandlerforworkzone.WrongPassword;
import com.jsp.workZone.util.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {

		Admin dbAdmin = adminDao.saveAdmin(admin);
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		structure.setData(dbAdmin);
		structure.setMsg("Data saved successfully....");
		structure.setStatus(HttpStatus.CREATED.value());

		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Admin>> findAdminById(int id) {

		Admin dbAdmin = adminDao.findAdminById(id);

		if (dbAdmin != null) {
			ResponseStructure<Admin> structure = new ResponseStructure<>();
			structure.setMsg("Admin id " + id + " found successfully.");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbAdmin);

			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.FOUND);
		} else {
			throw new AdminNotFound("Admin is not ther with id " + id);
		}
	}

	public ResponseEntity<ResponseStructure<List<Admin>>> findAdmindByName(String name) {

		List<Admin> dbAdmin = adminDao.findAdminByName(name);

		if (dbAdmin != null) {
			ResponseStructure<List<Admin>> structure = new ResponseStructure<>();
			structure.setMsg("Admin Name " + name + " found successfully.");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbAdmin);

			return new ResponseEntity<ResponseStructure<List<Admin>>>(structure, HttpStatus.FOUND);

		} else {
			throw new AdminNotFound("Admin is not ther with name " + name);
		}

	}

	public ResponseEntity<ResponseStructure<Admin>> deleteAdminById(int id) {

		Admin dbAdmin = adminDao.deleteAdmin(id);

		if (dbAdmin != null) {
			ResponseStructure<Admin> structure = new ResponseStructure<>();
			structure.setMsg("Admin id " + id + "deleted successfully.");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbAdmin);

			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.FOUND);
		} else {
			throw new AdminNotFound("Admin is not ther with id " + id);
		}
	}

//update admin

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin) {
		Admin dbAdmin = adminDao.updateAdmin(admin);

		if (dbAdmin != null) {
			ResponseStructure<Admin> structure = new ResponseStructure<>();
			structure.setMsg("Admin id " + admin.getId() + " found successfully.");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbAdmin);

			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.FOUND);
		} else {
			throw new AdminNotFound("Admin is not ther with id " + admin.getId());
		}
	}

//update admin ended

	// admin adress updated

	public ResponseEntity<ResponseStructure<Admin>> updateAdminAlongAdress(Admin admin) {
		Admin dbAdmin = adminDao.updateAdminAdress(admin);
		if (dbAdmin != null) {
			ResponseStructure<Admin> structure = new ResponseStructure<>();
			structure.setMsg("Admin id " + admin.getId() + " found successfully.");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbAdmin);

			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.FOUND);
		} else {
			throw new AdminNotFound("Admin is not ther with id " + admin.getId());
		}

		// admin adress update
	}

	public ResponseEntity<ResponseStructure<Admin>> login(String email, String pwd) {
			boolean flag=false;
		Admin dbAdmin = adminDao.findAdminByEmail(email);

		if (dbAdmin != null) {
			if(dbAdmin.getEmail().equals(email)) {
				if(dbAdmin.getPwd().equals(pwd)) {
					flag=true;
				}
				else {
					throw new WrongPassword("incorrect password....!");
				}
					
				}
			else {
				throw new WorngEmail("wrong email....!");
			}	
		}
			else {
				throw new AdminNotFound("Admin not found.....!");
			}
		if(flag==true) {
			ResponseStructure<Admin> structure = new ResponseStructure<>();
			structure.setMsg("Admin login  successfully.");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbAdmin);

			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.FOUND);
			
		}
		else {
			return null;
		}
	
	}
}
