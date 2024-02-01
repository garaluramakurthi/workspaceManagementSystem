package com.jsp.workZone.exceptionhandlerforworkzone;

import lombok.Data;

@Data
public class ClientNotFound  extends RuntimeException{
	
	private String msg = "Admin not found please try with different one.";

	public ClientNotFound(String msg) {
		super();
		this.msg = msg;
	}
	public ClientNotFound() {
		super();
	
	}

}
