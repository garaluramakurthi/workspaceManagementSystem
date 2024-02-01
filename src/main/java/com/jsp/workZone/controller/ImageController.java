package com.jsp.workZone.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.workZone.dto.Image;
import com.jsp.workZone.service.ImageService;
import com.jsp.workZone.util.ResponseStructure;

@RestController
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	@PostMapping("/saveimage")
	public ResponseEntity<ResponseStructure<Image>> saveImage( @RequestBody byte[] imageData) {
		return imageService.saveImage(imageData);
	}
	
	@GetMapping("/getimagebyid")
	public ResponseEntity<ResponseStructure<Image>> findImageById(@RequestParam int imageId) {
		return imageService.findImageById(imageId);
	}

}
