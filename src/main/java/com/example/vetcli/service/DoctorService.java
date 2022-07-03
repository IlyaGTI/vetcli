package com.example.vetcli.service;


import com.example.vetcli.model.Doctors;



public interface DoctorService {

    void addDoc(String fio, String spec);

    void updateDoc(Doctors doctors, String fio, String spec);

    void deleteDoc(Integer id);

    void findAll();

    Doctors findDocById(Integer id);
}
