package com.jsp.workZone.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.workZone.dto.Image;

public interface ImageRepo extends JpaRepository<Image, Integer> {

}
