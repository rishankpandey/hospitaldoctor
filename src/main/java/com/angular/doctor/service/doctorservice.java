package com.angular.doctor.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.angular.doctor.entity.doctor;

@Repository
public interface doctorservice {
	public List<doctor> getdoctor();
	public doctor getdoctorbyid(int id);
	public doctor adddoctor(doctor doc);

}
