package com.example.vetcli.repository;

import com.example.vetcli.model.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorsRepository extends JpaRepository<Doctors, Integer> {
    Doctors findByFio(String fio);
}
