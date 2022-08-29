package com.angular.doctor.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class doctor {
	@Id
	private int id;
	private String name;
	private String age;
	private String gender;
	private String speicalist;
	private int patientcount;
	public doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public doctor(int id, String name, String age, String gender, String speicalist, int patientcount) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.speicalist = speicalist;
		this.patientcount = patientcount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSpeicalist() {
		return speicalist;
	}
	public void setSpeicalist(String speicalist) {
		this.speicalist = speicalist;
	}
	public int getPatientcount() {
		return patientcount;
	}
	public void setPatientcount(int patientcount) {
		this.patientcount = patientcount;
	}
	@Override
	public String toString() {
		return "doctor [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", speicalist="
				+ speicalist + ", patientcount=" + patientcount + "]";
	}
	
	

}
