package com.Appointments.Doctor_Appointments.controller;
import com.Appointments.Doctor_Appointments.exception.ResourceNotFoundException;
import com.Appointments.Doctor_Appointments.repository.Appointments_Repository;
import com.Appointments.Doctor_Appointments.model.Appointment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins ="http://localhost:30003")
@RestController
@RequestMapping("/api/v1")
public class AppointmentController {
	
	@Autowired
	private Appointments_Repository Appointments_Repository;
	
	@PostMapping("/Appointments")
	public Appointment createPatient (@RequestBody Appointment createPatient) {
		System.out.println("this data is being posted");
		return Appointments_Repository .save(createPatient);
		
	}
	
//	get all memebers
	@GetMapping("/Appointments")
	public List<Appointment> getAppointment(){
		return Appointments_Repository.findAll();
	}
    
	
	
	@DeleteMapping("/Appointments/{id}") 
	  public ResponseEntity < Map < String, Boolean >> deletestudent(@PathVariable Long id) {
		Appointment member = Appointments_Repository.findById(id)
	          .orElseThrow(() -> new ResourceNotFoundException("student not exist with id :" + id));

	  	Appointments_Repository.delete(member);
	      Map < String, Boolean > response = new HashMap < > ();
	      response.put("deleted", Boolean.TRUE);
	      return ResponseEntity.ok(response);
	  } 
	 
	// get website by id rest api
	  @GetMapping("/Appointments/{id}")
	  public ResponseEntity <Appointment > getstudentById(@PathVariable Long id) {
		  Appointment patient = Appointments_Repository.findById(id)
	         .orElseThrow(() -> new ResourceNotFoundException("student not exist with id :" + id));
	      return ResponseEntity.ok(patient);
	   }

	//  // update website rest api

	   @PutMapping("/Appointments/{id}")
	  public ResponseEntity < Appointment > updatePatient(@PathVariable Long id, @RequestBody Appointment  Patientdetails) {
			
		   Appointment patient = Appointments_Repository.findById(id)
	           .orElseThrow(() -> new ResourceNotFoundException("student not exist with id :" + id));

			patient.setPatientname(Patientdetails.getPatientname());
//			patient.setPhoneNo(Patientdetails.getPhoneNo());
			patient.setAge(Patientdetails.getAge());
			patient.setGender(Patientdetails.getGender());
			patient.setLocation(Patientdetails.getLocation());
			patient.setDate(Patientdetails.getDate());
			patient.setTime(Patientdetails.getTime());
			patient.setComments(Patientdetails.getComments());
			
	 

			 Appointment updatePatient = Appointments_Repository.save(patient);
	     return ResponseEntity.ok(updatePatient);  }
	  
	  
}
