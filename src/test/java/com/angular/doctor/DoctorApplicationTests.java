package com.angular.doctor;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.angular.doctor.controller.DoctorController;
import com.angular.doctor.entity.doctor;
import com.angular.doctor.service.doctorservice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ComponentScan(basePackages= "com.angular.doctor")
@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest
class DoctorApplicationTests {
	
	@Autowired
	MockMvc mockMvc;
	
	@Mock
	private doctorservice dos;
	
	@InjectMocks
	private DoctorController dc;
	
	@BeforeEach
	public void setUp()
	{
		mockMvc=MockMvcBuilders.standaloneSetup(dc).build();
	}
	@Test
	public void getdoctorTest() throws Exception {
		List<doctor> mockdoctor=new ArrayList<doctor>();
		doctor temp1=new doctor(1,"Ajay","43","Male","Neurologist",1);
		mockdoctor.add(temp1);
		temp1=new doctor(1,"Satish","43","Male","Pediatrician",2);
		mockdoctor.add(temp1);
		
		Mockito.when(dos.getdoctor()).thenReturn(mockdoctor);
		
		RequestBuilder requestbuilder= MockMvcRequestBuilders.get("http://localhost:8081/doctor").accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestbuilder).andReturn();
		
		String outputinjson= result.getResponse().getContentAsString();
	    System.out.println(outputinjson);
		String expected= this.mapToJson(mockdoctor);
		
		JSONAssert.assertEquals(expected, outputinjson, false);	
		
	}	
	
	@Test
	public void adddoctorTest() throws Exception{
		doctor doc=new doctor(1,"Ajay","43","Male","Neurologist",1);
		String expected= this.mapToJson(doc);
		Mockito.when(dos.adddoctor(doc)).thenReturn(doc);
		
		RequestBuilder requestbuilder= MockMvcRequestBuilders.post("http://localhost:8081/doctor").content(expected).contentType(
	            MediaType.APPLICATION_JSON).accept(
	    				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestbuilder).andReturn();
		
		String outputinjson= result.getResponse().getContentAsString();
		System.out.println(expected);
		System.out.println(outputinjson);		
		
	}
	
	@Test
	public void getdoctorbyidTest() throws Exception {
		doctor doc=new doctor(1,"Ajay","43","Male","Neurologist",1);
		Mockito.when(dos.getdoctorbyid(1)).thenReturn(doc);
		
		RequestBuilder requestbuilder= MockMvcRequestBuilders.get("http://localhost:8081/doctor/{id}",1).accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestbuilder).andReturn();
		
		String outputinjson= result.getResponse().getContentAsString();
	    System.out.println(outputinjson);
		String expected= this.mapToJson(doc);	
		JSONAssert.assertEquals(expected, outputinjson, false);	
		
	}
	
	private String mapToJson(Object object) throws JsonProcessingException
	{
		ObjectMapper objectmapper= new ObjectMapper();
		return objectmapper.writeValueAsString(object);
	}
		
	}

