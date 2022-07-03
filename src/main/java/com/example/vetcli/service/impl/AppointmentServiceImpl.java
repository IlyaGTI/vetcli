package com.example.vetcli.service.impl;

import com.example.vetcli.model.Appointment;
import com.example.vetcli.model.Doctors;
import com.example.vetcli.model.Patient;
import com.example.vetcli.repository.AppointmentRepository;
import com.example.vetcli.repository.DoctorsRepository;
import com.example.vetcli.repository.PatientRepository;
import com.example.vetcli.service.AppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    public static final Logger LOG = LoggerFactory.getLogger(AppointmentServiceImpl.class);
    @Autowired
    private final DoctorsRepository doctorsRepository;
    @Autowired
    private final PatientRepository patientRepository;
    @Autowired
    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(DoctorsRepository doctorsRepository, PatientRepository patientRepository, AppointmentRepository appointmentRepository) {
        this.doctorsRepository = doctorsRepository;
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public void createAppoint(String doc, String pat, String date, String time, String status) {
        Doctors doctors = findDoctorByFio(doc);
        Patient patient = findPatientByName(pat);

        Appointment appointment = new Appointment();

        appointment.setDoctors(doctors);
        appointment.setPatient(patient);
        appointment.setDate(LocalDate.parse(date));
        appointment.setTime(LocalTime.parse(time));
        appointment.setStatus(status);

        appointmentRepository.save(appointment);

        LOG.info("Прием под номером " + appointment.getId() + " создан");
    }

    @Override
    public void updateStatus(Appointment appointment, String status) {
        appointment.setStatus(status);
        appointmentRepository.save(appointment);

        LOG.info("Статус приема под номером " + appointment.getId() + " изменен");
    }

    @Override
    public void deleteAppoint(Integer id) {
        Appointment appointment = findAppointById(id);

        appointmentRepository.delete(appointment);

        LOG.info("Прием удален");
    }

    @Override
    public Appointment findAppointById(Integer id) {
        return appointmentRepository.findById(id).get();
    }

    @Override
    public List<Appointment> findAllAppointByPat(Patient patient) {
        return appointmentRepository.findAllByPatient(patient);
    }

    @Override
    public List<Appointment> findAllAppointByDoc(Doctors doctors) {
        return appointmentRepository.findAllByDoctors(doctors);
    }

    public Patient findPatientByName(String name) {
        return patientRepository.findByName(name);
    }

    public Doctors findDoctorByFio(String fio) {
        return doctorsRepository.findByFio(fio);
    }

    public void findAllAppoint() {
        appointmentRepository.findAll().stream().forEach(System.out::println);

    }

}
