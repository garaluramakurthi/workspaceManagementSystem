package com.jsp.workZone.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.workZone.dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
