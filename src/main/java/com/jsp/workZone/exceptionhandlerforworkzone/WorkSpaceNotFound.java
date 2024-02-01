package com.jsp.workZone.exceptionhandlerforworkzone;

import lombok.Data;

@Data
public class WorkSpaceNotFound  extends RuntimeException{
	private String msg = "WorkSpace  not found....!";

	public WorkSpaceNotFound(String msg) {
		super();
		this.msg = msg;
	}
	
	public WorkSpaceNotFound() {
		super();
	
	}
}
