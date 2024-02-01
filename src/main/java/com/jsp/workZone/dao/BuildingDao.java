package com.jsp.workZone.dao;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.workZone.dto.Building;
import com.jsp.workZone.repo.BuildingRepo;


@Repository
public class BuildingDao {

	@Autowired
	private BuildingRepo buildingRepo;

	public Building saveBuilding(Building building) {
		return buildingRepo.save(building);
	}

	public List<Building> fetchBuildingByName(String buildingName) {

		List<Building> db = buildingRepo.fetchbuildingByName(buildingName);

		if (db.isEmpty()) {
			return null;
		} else {
			return db;
		}
	}

	public List<Building> findBuildingByAddress(String city) {

		List<Building> db = buildingRepo.findBuildingByAddress(city);

		if (db.isEmpty()) {
			return null;
		} else {
			return db;
		}
	}

	public Building findBuildingById(int id) {

		if (buildingRepo.findById(id).isPresent()) {

			Building db = buildingRepo.findById(id).get();

			return db;
		} else {
			return null;
		}
	}

	public Building findManagerById(int id) {

		Building val = buildingRepo.findManagerById(id);

		if (val != null) {

			return val;

		} else {
			return null;
		}

	}

	public List<Building> fetchAllBuildings() {

		return buildingRepo.findAll();

	}

	public Building updateBuilding(Building building) {

		if (buildingRepo.findById(building.getId()).isPresent()) {
			Building dbbuilding = buildingRepo.findById(building.getId()).get();

			if (building.getBuilding_Name() != null) {
				dbbuilding.setBuilding_Name(building.getBuilding_Name());
			}
			if (building.getRatings() != 0) {
				dbbuilding.setRatings(building.getRatings());
			}
			if (building.getAddress() != null) {
				dbbuilding.setAddress(building.getAddress());
			}
			if (building.getAdmin() != null) {
				dbbuilding.setAdmin(building.getAdmin());
			}
			if (building.getManager() != null) {
				dbbuilding.setManager(building.getManager());
			}

			Building updatedBuilding = buildingRepo.save(dbbuilding);
			return updatedBuilding;

		} else {
			return null;
		}

	}

	public Building deleteBuilding(int id) {

		if (buildingRepo.findById(id).isPresent()) {
			Building val = buildingRepo.findById(id).get();
			buildingRepo.delete(val);
			return val;

		} else {
			return null;
		}

	}

}
