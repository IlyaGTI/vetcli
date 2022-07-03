package com.example.vetcli.service.impl;

import com.example.vetcli.model.Doctors;
import com.example.vetcli.repository.DoctorsRepository;
import com.example.vetcli.service.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoctorServiceImpl implements DoctorService {

    public static final Logger LOG = LoggerFactory.getLogger(DoctorServiceImpl.class);

    @Autowired
    private final DoctorsRepository doctorsRepository;

    public DoctorServiceImpl(DoctorsRepository doctorsRepository) {
        this.doctorsRepository = doctorsRepository;
    }

    @Override
    public void addDoc(String fio, String spec) {

        Doctors doctors = new Doctors();
        doctors.setFio(fio);
        doctors.setSpecialization(spec);

        doctorsRepository.save(doctors);

        LOG.info("Доктор " + fio + " успешно добавлен");

    }

    @Override
    public void updateDoc(Doctors doctors, String fio, String spec) {

        doctors.setFio(fio);
        doctors.setSpecialization(spec);

        doctorsRepository.save(doctors);

        LOG.info("Данные доктора с id = " + doctors.getId() + " успешно обновлены");

    }

    @Override
    public void deleteDoc(Integer id) {

        Doctors doctors = findDocById(id);

        doctorsRepository.delete(doctors);

        LOG.info("Доктор удален");

    }

    @Override
    public void findAll() {

        List<Doctors> doctors = doctorsRepository.findAll();

        doctors.stream().forEach(System.out::println);

    }

    @Override
    public Doctors findDocById(Integer id) {
        return doctorsRepository.findById(id).get();
    }
}
