package com.jsp.workZone.exceptionhandlerforworkzone;

import lombok.Data;

@Data
public class ManagerNotfound extends RuntimeException {
	
	private String msg="Manager not found.";

	public ManagerNotfound(String msg) {
		super();
		this.msg = msg;
	}

	public ManagerNotfound() {
		super();
	}
	
	

}
