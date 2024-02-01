package com.jsp.workZone.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.workZone.dto.ClientBooking;
import com.jsp.workZone.repo.ClientBookingRepo;
@Repository
public class ClientBookingsDao {
	
	@Autowired
	ClientBookingRepo clientBookingRepo;
	
	
	
	public ClientBooking saveBookings(ClientBooking booking ) {

	return 	clientBookingRepo.save(booking);
	
	}

}
