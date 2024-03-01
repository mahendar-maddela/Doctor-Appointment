package com.Appointments.Doctor_Appointments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Appointments.Doctor_Appointments.model.Appointment;
import com.Appointments.Doctor_Appointments.model.Register;
import com.Appointments.Doctor_Appointments.repository.Registor_Repository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class RegisterController {

    @Autowired
    private Registor_Repository registorRepository;

    @PostMapping("/User/create")
    public Register createUser(@RequestBody Register newUser) {
        System.out.println("Data is being posted");
        return registorRepository.save(newUser);
    }
    @GetMapping("/User")
	public List<Register> getUser(){
		return registorRepository.findAll();
	}
    @PostMapping("/User")
    public String loginUser(@RequestBody Register loginRequest) {
        // Retrieve user by email
        Register user = registorRepository.findByEmail(loginRequest.getEmail());
        
        if (user == null) {
            return "User not found";
        }

        // Check if passwords match
        if (user.getPassword().equals(loginRequest.getPassword())) {
            return "Login successful";
        } else {
            return "Incorrect password";
        }
    }

}






