package com.example.vetcli.service;

import com.example.vetcli.model.Appointment;
import com.example.vetcli.model.Doctors;
import com.example.vetcli.model.Patient;

import java.util.*;

public interface AppointmentService {

    void createAppoint(String doc, String pat, String date, String time, String status);

    void updateStatus(Appointment appointment, String status);

    void deleteAppoint(Integer id);

    Appointment findAppointById(Integer id);

    List<Appointment> findAllAppointByPat(Patient patient);

    List<Appointment> findAllAppointByDoc(Doctors doctors);

}
