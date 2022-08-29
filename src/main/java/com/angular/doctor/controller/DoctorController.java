package com.angular.doctor.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angular.doctor.dao.doctorDao;
import com.angular.doctor.entity.doctor;
import com.angular.doctor.service.doctorservice;

@RestController
@CrossOrigin("*")
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private doctorservice docser;
	
	@Autowired
	private doctorDao ddao;
	
	@GetMapping("")
	public List<doctor> getdoctors(){
		return docser.getdoctor();
		
	}
	
	@GetMapping("/{id}")
	public doctor getdoctorbyid(@PathVariable(value= "id") int id) {
		return docser.getdoctorbyid(id);
	}
	
	@PostMapping(path=""  , consumes="application/json")
	public ResponseEntity<doctor> adddoctor(@RequestBody doctor doc) {
		try {
		doctor doct= docser.adddoctor(doc);
		return new ResponseEntity<doctor>(doct,HttpStatus.CREATED);
	}catch(NoSuchElementException e) {
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}}
	
	@GetMapping("/addpatient/{visiteddoctor}")
	public ResponseEntity<String> incrementcount(@PathVariable("visiteddoctor") String visiteddoctor){
		int id =Integer.parseInt(visiteddoctor);
		doctor d=ddao.findById(id).get();
		int p=d.getPatientcount();
		String s=d.getName();
		d.setPatientcount(p+1);
		ddao.save(d);
		return ResponseEntity.status(HttpStatus.OK).body(s);	
	}
	
	
	
	

}
