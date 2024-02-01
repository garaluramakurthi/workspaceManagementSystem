package com.jsp.workZone.exceptionhandlerforworkzone;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.workZone.util.ResponseStructure;

@RestControllerAdvice
public class ExceptionHandlerForWorkZone {

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>> sqlExceptionHandler(SQLIntegrityConstraintViolationException ex) {

		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMsg("you cannot perform this operation");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AdminNotFound.class)
	public ResponseEntity<ResponseStructure<String>> adminNotFound(AdminNotFound adminNotFound) {

		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(adminNotFound.getMsg());
		structure.setMsg("admin does not exist in the database.");
		structure.setStatus(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(WorkSpaceNotFound.class)
	public ResponseEntity<ResponseStructure<String>> WorkSpaceNotFound(WorkSpaceNotFound wsnf) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(wsnf.getMessage());
		structure.setMsg("work space not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(BuildingNotfound.class)
	public ResponseEntity<ResponseStructure<String>> buildingNotFound(BuildingNotfound buildingNotfound) {

		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(buildingNotfound.getMsg());
		structure.setMsg("Building not found!");
		structure.setStatus(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ManagerNotfound.class)
	public ResponseEntity<ResponseStructure<String>> managerNotfound(ManagerNotfound managerNotfound) {

		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(managerNotfound.getMsg());
		structure.setMsg("Manager not found!");
		structure.setStatus(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ImageNotFound.class)
	public ResponseEntity<ResponseStructure<String>> imageNotFound(ImageNotFound imageNotFound) {

		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(imageNotFound.getMsg());
		structure.setMsg("Image not saved!");
		structure.setStatus(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ManagerAlreadyAssignAnotherBuilding.class)
	public ResponseEntity<ResponseStructure<String>> managerAlreadyAssignAnotherBuilding(
			ManagerAlreadyAssignAnotherBuilding expec) {

		ResponseStructure<String> structure = new ResponseStructure<>();

		structure.setData(expec.getMessage());

		structure.setMsg("Manger is Assingened Another Building!");

		structure.setStatus(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(FloorNotFound.class)
	public ResponseEntity<ResponseStructure<String>> floorNotFound(FloorNotFound e) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(e.getMessage());
		structure.setMsg("floor not found...!");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(WorngEmail.class)
	public ResponseEntity<ResponseStructure<String>> WrongEmail(WorngEmail wrongemail) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(wrongemail.getMessage());
		structure.setMsg("wrong email....!");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(WrongPassword.class)
	public ResponseEntity<ResponseStructure<String>> WrongPassword(WrongPassword wrongpwd) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(wrongpwd.getMessage());
		structure.setMsg("wrong password...!");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(ClientNotFound.class)
	public ResponseEntity<ResponseStructure<String>> ClientNotFound(ClientNotFound cnf) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(cnf.getMessage());
		structure.setMsg("client not found.....!");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}


	
}
