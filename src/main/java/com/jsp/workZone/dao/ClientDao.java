package com.jsp.workZone.dao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import com.jsp.workZone.dto.Client;
import com.jsp.workZone.repo.ClientRepo;

@Repository
public class ClientDao {

	@Autowired
	private ClientRepo clientRepo;

	public Client saveClient(Client client) {
		return clientRepo.save(client);
	}

	public Client findClientByEmail(String email) {

		Client val = clientRepo.fetchByEmail(email);

		if (val != null) {
			return val;

		} else {

			return null;
		}

	}

	public Client fetchClientById(int id) {
		
		if (clientRepo.findById(id).isPresent()) {
			Client val = clientRepo.findById(id).get();
			return val;

		}
		else {
			return null;
		}

	}
	
	public Client UpdateClient(Client client) {
		
		Client dbclient = clientRepo.findById(client.getId()).get();
					
			if(dbclient!=null) {
				
				if(client.getName()!=null) {
					dbclient.setName(client.getName());
					
				}
				if(client.getEmail()!=null) {
					dbclient.setEmail(client.getEmail());
					
				}
				if(client.getAge()!=0) {
					client.setAge(client.getAge());	
				}
				if(client.getGender()!=null) {
					dbclient.setGender(client.getGender());
					
				}
				if(client.getId_proof()!=null) {
					dbclient.setId_proof(client.getId_proof());
					
				}
				if(client.getBookins()!=null) {
					dbclient.setBookins(client.getBookins());
					
				}
				if(client.getAddress()!=null) {
					dbclient.setAddress(client.getAddress());
					
				}
				Client res = clientRepo.save(dbclient);
				return res;
				
			}
			else {
				return null;
			}
		}
		
		
	

}
