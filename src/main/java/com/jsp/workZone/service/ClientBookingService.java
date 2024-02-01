package com.jsp.workZone.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.workZone.dao.ClientBookingsDao;
import com.jsp.workZone.dao.ClientDao;
import com.jsp.workZone.dao.WorkSpaceDao;

import com.jsp.workZone.dto.Client;
import com.jsp.workZone.dto.ClientBooking;
import com.jsp.workZone.dto.WorkSpace;
import com.jsp.workZone.exceptionhandlerforworkzone.ClientNotFound;
import com.jsp.workZone.exceptionhandlerforworkzone.WorkSpaceNotFound;
import com.jsp.workZone.util.ResponseStructure;

@Service
public class ClientBookingService {
	@Autowired
	private ClientBookingsDao bookingsDao;
	@Autowired
	private ClientDao clientDao;
	@Autowired
	private WorkSpaceDao spaceDao;

	public ResponseEntity<ResponseStructure<WorkSpace>> bookOneWorkSpace(int clientId, int workSpaceId,
			ClientBooking clientBooking) {
		Client dbClient = clientDao.fetchClientById(clientId);
		List<Client> listClient = new ArrayList<Client>();

		WorkSpace dbWorkSpace = spaceDao.fetchById(workSpaceId);
		if (dbClient != null) {
			if (dbWorkSpace != null) {
				if (dbWorkSpace.getAvailability().equalsIgnoreCase("yes")) {

					double pricePerDay = dbWorkSpace.getPricePerDay();
					int day = (clientBooking.getEntryDate().getDate());
					int day1 = (clientBooking.getExitDate().getDate());

					int month = clientBooking.getEntryDate().getMonth();
					int month1 = clientBooking.getExitDate().getMonth();

					int year = clientBooking.getEntryDate().getYear();
					int year1 = clientBooking.getExitDate().getYear();

					int totalDays = ((day1 - day) + ((month1 - month) * 30) + ((year1 - year) * 365));
					
					System.out.println("total days " + totalDays);
					double cost = dbWorkSpace.getPricePerDay() * totalDays;
					System.out.println("price per day" + dbWorkSpace.getPricePerDay());

					System.out.println("price per day * total days = " + cost);

					clientBooking.setCost(cost);
					dbWorkSpace.setAvailability("no");

					dbWorkSpace.setClients(listClient);
					spaceDao.saveWorkSpace(dbWorkSpace);
					bookingsDao.saveBookings(clientBooking);

					ResponseStructure<WorkSpace> structure = new ResponseStructure<WorkSpace>();
					structure.setMsg("your booking is under prosess waiting for manager conformation");
					structure.setStatus(HttpStatus.OK.value());
					structure.setData(dbWorkSpace);
					return new ResponseEntity<ResponseStructure<WorkSpace>>(structure, HttpStatus.OK);
				} else {
					throw new WorkSpaceNotFound("this workspace not available");
				}
			} else {
				throw new WorkSpaceNotFound("workSpace not exist with id = " + workSpaceId);
			}

		} else {
			throw new ClientNotFound("Client not exist with id = " + clientId);
		}
	}
}
