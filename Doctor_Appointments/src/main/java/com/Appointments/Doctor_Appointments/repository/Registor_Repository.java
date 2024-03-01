package com.Appointments.Doctor_Appointments.repository;

import com.Appointments.Doctor_Appointments.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Registor_Repository extends JpaRepository<Register, Long> {

    Register findByEmail(String email);
}



