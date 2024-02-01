package com.jsp.workZone.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.workZone.dto.Building;
import com.jsp.workZone.dto.Manager;
import com.jsp.workZone.repo.BuildingRepo;
import com.jsp.workZone.repo.ManagerRepo;

@Repository
public class ManagerDao {

	@Autowired
	private ManagerRepo managerRepo;

	@Autowired
	private BuildingRepo buildingRepo;

	public Manager saveManager(Manager manager) {

		return managerRepo.save(manager);
	}

	public Manager findManagerById(int id) {

		if (managerRepo.findById(id).isPresent()) {
			Manager manager = managerRepo.findById(id).get();
			return manager;

		} else {
			return null;
		}

	}

	public List<Manager> findManagerByName(String name) {

		List<Manager> val = managerRepo.findManagerByName(name);

		if (val.isEmpty()) {
			return null;

		} else {

			return val;
		}

	}

	public Manager updateManager(Manager manager) {
		if (managerRepo.findById(manager.getId()).isPresent()) {
			Manager managerid = managerRepo.findById(manager.getId()).get();
			if (manager.getEmail() != null) {
				managerid.setEmail(manager.getEmail());

			}
			if (manager.getExperience() != 0) {
				managerid.setExperience(manager.getExperience());
			}
			if (manager.getName() != null) {
				managerid.setName(manager.getName());

			}
			if (manager.getPhone() != 0) {
				managerid.setPhone(manager.getPhone());
			}
			if (manager.getPwd() != null) {
				managerid.setPwd(manager.getPwd());
			}
			Manager managerdetails = managerRepo.save(managerid);
			return managerdetails;
		} else {
			return null;
		}
	}

	public List<Manager> findManagerExperience(int experience) {

		List<Manager> val = managerRepo.findManagerByExperience(experience);

		if (val.isEmpty()) {
			return null;

		} else {

			return val;
		}

	}

	public Manager deleteManagerById(int id) {

		if (managerRepo.findById(id).isPresent()) {
			Manager manager = managerRepo.findById(id).get();
			Building val = buildingRepo.findManagerById(id);

			if (val != null) {
				val.setManager(null);
				buildingRepo.save(val);
			}

			managerRepo.deleteById(id);
			return manager;

		} else {
			return null;
		}

	}

	public Manager findManagerByEmail(String email) {
		Manager val = managerRepo.fetchManger(email);
		if (val != null) {
			return val;

		} else {

			return null;
		}

	}

}
