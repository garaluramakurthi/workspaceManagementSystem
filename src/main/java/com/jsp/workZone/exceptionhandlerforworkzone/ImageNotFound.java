package com.jsp.workZone.exceptionhandlerforworkzone;

import org.springframework.http.ResponseEntity;

import com.jsp.workZone.dto.Image;
import com.jsp.workZone.util.ResponseStructure;

import lombok.Data;

@Data
public class ImageNotFound extends RuntimeException {
	
	private String msg = "Image Not found!.";

	public ImageNotFound(String msg) {
		super();
		this.msg = msg;
	}

	public ImageNotFound() {
		super();
	}
	
	

}
