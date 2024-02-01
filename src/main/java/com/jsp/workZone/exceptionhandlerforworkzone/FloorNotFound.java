package com.jsp.workZone.exceptionhandlerforworkzone;

import lombok.Data;

@Data
public class FloorNotFound  extends RuntimeException{
	private String msg = " floor not found";

	public FloorNotFound(String msg) {
		super();
		this.msg = msg;
	}
	public FloorNotFound() {
		super();
	}


}
