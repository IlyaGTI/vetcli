package com.example.vetcli.repository;

import com.example.vetcli.model.Appointment;
import com.example.vetcli.model.Doctors;
import com.example.vetcli.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findAllByPatient(Patient patient);
    List<Appointment> findAllByDoctors(Doctors doctors);
}
