package com.Appointments.Doctor_Appointments.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Doctor_Appontments")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "patientname")
	private String patientname;
	
	@Column (name ="phoneNo")
	private long phoneNo;
	
	@Column (name ="age")
	private int age ;
	
	@Column (name="gender")
	private String gender;
	
	@Column (name="location")
	private String location;
	
	@Column (name="date")
	private String date;
	
	@Column (name="time")
	private String time;
	
	@Column (name="comments")
	private String comments;
	
	public Appointment() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	

}
