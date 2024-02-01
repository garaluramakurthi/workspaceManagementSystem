package com.jsp.workZone.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.jsp.workZone.dto.Building;
import com.jsp.workZone.dto.WorkSpace;
import com.jsp.workZone.enums.WorkSpaceType;

public interface WorkspaceRepo extends JpaRepository<WorkSpace, Integer>{

	@Query("Select a from WorkSpace a where capacity=?1")
	public List<Building> fetchWorkSpaceCapacity(int capacity);
	
	
	@Query("select a from WorkSpace a where spaceType=?1")
	public List<WorkSpace> fetchByType(WorkSpaceType spaceType);
	
	@Query("select a from WorkSpace a where cost=?1")
	public List<WorkSpace> fetchByCost(double cost);
	

	


	
}
