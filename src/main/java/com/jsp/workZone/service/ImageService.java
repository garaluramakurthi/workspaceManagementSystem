package com.jsp.workZone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.jsp.workZone.dao.ImageDao;
import com.jsp.workZone.dto.Image;
import com.jsp.workZone.exceptionhandlerforworkzone.ImageNotFound;
import com.jsp.workZone.util.ResponseStructure;

@Service
public class ImageService {

	@Autowired
	private ImageDao imageDao;

	public ResponseEntity<ResponseStructure<Image>> saveImage(byte[] imageData) {

		if (imageData != null) {
			Image image = new Image();

			image.setImageData(imageData);
			Image dbImage = imageDao.saveImage(image);
			ResponseStructure<Image> structure = new ResponseStructure<>();
			structure.setMsg("image saved successfully.");
			structure.setData(dbImage);
			structure.setStatus(HttpStatus.CREATED.value());

			return new ResponseEntity<ResponseStructure<Image>>(structure, HttpStatus.CREATED);
		} else {

			throw new ImageNotFound("Please select an Image first");
		}

	}

	public ResponseEntity<ResponseStructure<Image>> findImageById(int imageId) {
		if (imageDao.findImageById(imageId) != null) {

			Image dbimage = imageDao.findImageById(imageId);
			ResponseStructure<Image> structure = new ResponseStructure<>();
			structure.setData(dbimage);
			structure.setMsg("Id " + imageId + " found successfully");
			structure.setStatus(HttpStatus.FOUND.value());

			return new ResponseEntity<ResponseStructure<Image>>(structure, HttpStatus.FOUND);

		} else {
			throw new ImageNotFound("image with particular id is not there. ");
		}
	}

}
