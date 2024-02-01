package com.jsp.workZone.exceptionhandlerforworkzone;

import lombok.Data;

@Data
public class BuildingNotfound extends RuntimeException {
	
	private String msg = " Building not found.";

	public BuildingNotfound(String msg) {
		super();
		this.msg = msg;
	}

	public BuildingNotfound() {
		super();
	}
	
	

}
