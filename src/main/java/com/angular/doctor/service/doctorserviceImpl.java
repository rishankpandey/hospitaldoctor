package com.angular.doctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.doctor.dao.doctorDao;
import com.angular.doctor.entity.doctor;

@Service
public class doctorserviceImpl implements doctorservice {
	
	@Autowired
	private doctorDao docdao;

	@Override
	public List<doctor> getdoctor() {
		// TODO Auto-generated method stub
		return docdao.findAll();
	}

	@Override
	public doctor getdoctorbyid(int id) {
		// TODO Auto-generated method stub
		return docdao.findById(id).get();
	}

	@Override
	public doctor adddoctor(doctor doc) {
		// TODO Auto-generated method stub
		return docdao.save(doc);
	}

}
