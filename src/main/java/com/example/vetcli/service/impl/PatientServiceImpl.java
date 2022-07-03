package com.example.vetcli.service.impl;

import com.example.vetcli.model.Patient;
import com.example.vetcli.repository.PatientRepository;
import com.example.vetcli.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.time.LocalDate;

@Service
public class PatientServiceImpl implements PatientService {

    public static final Logger LOG = LoggerFactory.getLogger(PatientServiceImpl.class);

    @Autowired
    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void addPat(String name) {

        Patient patient = new Patient();
        patient.setName(name);
        patient.setDate_create(LocalDate.now());

        patientRepository.save(patient);

        LOG.info("Пациент с именем " + name + " создан");

    }

    @Override
    public void updatePat(Patient patient, String name) {

        patient.setName(name);

        patientRepository.save(patient);

        LOG.info("Данные пациента с Id " + patient.getId() + " были изменены");

    }

    @Override
    public void deletePat(Integer id) {

        Patient patient = findPatById(id);

        patientRepository.delete(patient);

        LOG.info("Пациент удален");

    }

    @Override
    public Patient findPatById(Integer id) {
        return  patientRepository.findById(id).get();
    }

    public void findAllPat() {
        patientRepository.findAll().stream().forEach(System.out::println);
    }
}
