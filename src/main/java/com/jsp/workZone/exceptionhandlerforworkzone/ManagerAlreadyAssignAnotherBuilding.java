package com.jsp.workZone.exceptionhandlerforworkzone;

import lombok.Data;

@Data
public class ManagerAlreadyAssignAnotherBuilding  extends RuntimeException{
	
	private String msg = "Manager is Already Assign To Another Building ";

	public ManagerAlreadyAssignAnotherBuilding(String msg) {
		super();
		this.msg = msg;
	}
	
	
	public ManagerAlreadyAssignAnotherBuilding() {
		super();
		
	}

}
