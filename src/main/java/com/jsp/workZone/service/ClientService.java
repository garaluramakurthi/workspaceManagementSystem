package com.jsp.workZone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.workZone.dao.ClientDao;
import com.jsp.workZone.dto.Client;
import com.jsp.workZone.exceptionhandlerforworkzone.ClientNotFound;
import com.jsp.workZone.exceptionhandlerforworkzone.WorngEmail;
import com.jsp.workZone.exceptionhandlerforworkzone.WrongPassword;
import com.jsp.workZone.util.ResponseStructure;

@Service
public class ClientService {

	@Autowired
	private ClientDao clientDao;

	public ResponseEntity<ResponseStructure<Client>> saveClient(Client client) {

		Client dbClient = clientDao.saveClient(client);

		ResponseStructure<Client> structure = new ResponseStructure<Client>();

		structure.setData(dbClient);
		structure.setMsg("Client Data Saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());

		return new ResponseEntity<ResponseStructure<Client>>(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Client>> loginClient(String email, String pwd) {

		Client dbClient = clientDao.findClientByEmail(email);
	
			if (dbClient.getEmail().equals(email)) {
				if(dbClient.getPwd().equals(pwd)) {
				ResponseStructure<Client> structure = new ResponseStructure<Client>();

				structure.setData(dbClient);
				structure.setMsg("Client login done Sucessfully");
				structure.setStatus(HttpStatus.CREATED.value());

				return new ResponseEntity<ResponseStructure<Client>>(structure, HttpStatus.CREATED);
				}
				else {
					throw new WrongPassword("Worong passwordd.......!");
				}
			}
			else {
				throw new WorngEmail("Wrong email.......!");
			}

		}
	public ResponseEntity<ResponseStructure<Client>> findByid(int id){
		Client dbClient = clientDao.fetchClientById(id);
		if(dbClient!=null) {
		
		ResponseStructure<Client> structure = new ResponseStructure<Client>();
		structure.setMsg("Client found Sucessfully");
		structure.setData(dbClient);
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Client>>(structure,HttpStatus.FOUND);
		
		}
		else {
			throw new ClientNotFound("Client not found");
		}
		
		
	}
	public ResponseEntity<ResponseStructure<Client>> updateClient(Client client){
		Client dbclient = clientDao.UpdateClient(client);
		
		if(dbclient!=null) {
			ResponseStructure<Client> structure = new ResponseStructure<Client>();
			structure.setMsg("Client found Sucessfully");
			structure.setData(dbclient);
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Client>>(structure,HttpStatus.FOUND);	
		}
		else {
			throw new ClientNotFound("Client not found");
		}
		
	}
	
	

}
