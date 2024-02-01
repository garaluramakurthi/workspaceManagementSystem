package com.jsp.workZone.exceptionhandlerforworkzone;

import lombok.Data;

@Data
public class WorngEmail extends RuntimeException {
	
	private String msg = " Building not found.";

	public WorngEmail(String msg) {
		super();
		this.msg = msg;
	}
	public WorngEmail() {
		super();
	
	}

}
