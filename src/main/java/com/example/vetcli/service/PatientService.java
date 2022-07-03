package com.example.vetcli.service;

import com.example.vetcli.model.Patient;

public interface PatientService {

    void addPat(String name);

    void updatePat(Patient patient, String name);

    void deletePat(Integer id);

    Patient findPatById(Integer id);
}
