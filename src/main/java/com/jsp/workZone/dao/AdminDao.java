package com.jsp.workZone.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.workZone.dto.Address;
import com.jsp.workZone.dto.Admin;
import com.jsp.workZone.dto.Building;
import com.jsp.workZone.repo.AddressRepo;
import com.jsp.workZone.repo.AdminRepo;
import com.jsp.workZone.repo.BuildingRepo;

@Repository
public class AdminDao {

	@Autowired
	private AdminRepo adminRepo;

	@Autowired
	private BuildingRepo buildingRepo;
	@Autowired
	private AddressDao addressDao;

	@Autowired
	AddressRepo addressRepo;

	public Admin saveAdmin(Admin admin) {

		return adminRepo.save(admin);
	}

	public Admin findAdminById(int id) {

		if (adminRepo.findById(id).isPresent()) {

			Admin admin = adminRepo.findById(id).get();

			return admin;

		} else {
			return null;
		}
	}

	public List<Admin> findAdminByName(String name) {

		List<Admin> val = adminRepo.findAdminByName(name);

		if (val.isEmpty()) {
			return null;

		} else {

			return val;
		}

	}

	public Admin deleteAdmin(int id) {

		Optional<Admin> val = adminRepo.findById(id);

		if (val.isPresent()) {

			List<Building> list = buildingRepo.deleteAdminById(id);
			System.out.println(list);

			for (Building building : list) {

				if (building.getAdmin().getId() == id) {

					// building.setAddress(null);
					// building.setManager(null);
					// buildingRepo.save(building);
					// building.setAdmin(null);

					buildingRepo.delete(building);

				}

			}

			adminRepo.deleteById(id);
			return val.get();

		} else {
			return null;
		}

	}

	public Admin updateAdmin(Admin admin) {

		if (adminRepo.findById(admin.getId()).isPresent()) {

			Admin db = adminRepo.findById(admin.getId()).get();

			if (admin.getName() != null) {

				db.setName(admin.getName());
			}
			if (admin.getEmail() != null) {
				db.setEmail(admin.getEmail());
			}
			if (admin.getPhone() != 0) {
				db.setPhone(admin.getPhone());
			}
			if (admin.getPwd() != null) {
				db.setPwd(admin.getPwd());
			}
			if (admin.getGender() != null) {
				db.setGender(admin.getGender());
			}

			Admin updateDb = adminRepo.save(db);

			return updateDb;

		} else {
			return null;
		}

	}

	public Admin updateAdminAdress(Admin admin) {
		Admin admin2 = adminRepo.findById(admin.getId()).get();

		if (admin2 != null) {

			// added

			Admin db = adminRepo.findById(admin.getId()).get();

			if (admin.getName() != null) {

				db.setName(admin.getName());
			}
			if (admin.getEmail() != null) {
				db.setEmail(admin.getEmail());
			}
			if (admin.getPhone() != 0) {
				db.setPhone(admin.getPhone());
			}
			if (admin.getPwd() != null) {
				db.setPwd(admin.getPwd());
			}
			if (admin.getGender() != null) {
				db.setGender(admin.getGender());
			}
			
			Address address = addressDao.updateAdress(admin.getAddress());
			if (address != null) {

				adminRepo.save(admin2);
			}

			Admin res = adminRepo.save(admin2);
			return res;
		} else {
			return null;
		}

	}

	public Admin findAdminByEmail(String email) {

		Admin val = adminRepo.findAdminByEmail(email);

		if (val != null) {
			return val;

		} else {

			return null;
		}

	}

}
