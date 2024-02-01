package com.jsp.workZone.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Building {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String building_Name;
	private int ratings;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Manager manager;
	
	
	@OneToOne (cascade = CascadeType.ALL)
	private Address address;
	
	
	@ManyToOne
	private Admin admin;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Floor> floors;
	
	

}
