package com.jsp.workZone.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.jsp.workZone.enums.WorkSpaceType;


import lombok.Data;

@Entity
@Data
public class WorkSpace {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int capacity;
	private WorkSpaceType spaceType;
	private double cost;
	private double pricePerDay;
	private String availability;
	private String squareFeet;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Client> clients;
	

}
