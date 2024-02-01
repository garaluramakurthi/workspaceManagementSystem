package com.jsp.workZone.util;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	
	private int status;
	private String msg;
	private T data;

}
