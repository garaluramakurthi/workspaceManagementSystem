package com.jsp.workZone.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ClientBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int booking_id;
	private Date entryDate;
	private Date exitDate;
	private double cost;
	private String payment;
	

}
