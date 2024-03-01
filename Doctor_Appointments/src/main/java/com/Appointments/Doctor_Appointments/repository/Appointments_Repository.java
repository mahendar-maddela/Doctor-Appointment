package com.Appointments.Doctor_Appointments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Appointments.Doctor_Appointments.model.Appointment;
import com.Appointments.Doctor_Appointments.model.Register;


public interface Appointments_Repository  extends JpaRepository <Appointment, Long  >{

}
    