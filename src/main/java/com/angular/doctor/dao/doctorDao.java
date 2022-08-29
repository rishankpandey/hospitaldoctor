package com.angular.doctor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angular.doctor.entity.doctor;

@Repository
public interface doctorDao extends JpaRepository<doctor,Integer> {
	
}
