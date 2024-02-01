package com.jsp.workZone.exceptionhandlerforworkzone;

import lombok.Data;

@Data
public class WorkSpaceCapacityNotFound  extends RuntimeException{
	
	private String msg="WorkSpace  capacity is not Available";
	
	public WorkSpaceCapacityNotFound(String msg) {
		super();
		this.msg = msg;
	}
	public WorkSpaceCapacityNotFound() {
		super();
		
	}

	
}
