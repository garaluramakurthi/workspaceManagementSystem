package com.jsp.workZone.exceptionhandlerforworkzone;

import lombok.Data;

@Data
public class WrongPassword extends RuntimeException {
	private String msg = "Worng Password....!";

	public WrongPassword(String msg) {
		super();
		this.msg = msg;
	}
	public WrongPassword() {
		super();
	
	}


}
