package com.example.vetcli.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "doctor")
public class Doctors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String fio;
    private String specialization;

    public Doctors() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Доктор {" +
                "id =" + id +
                ", ФИО ='" + fio + '\'' +
                ", Специализация ='" + specialization + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctors)) return false;
        Doctors doctors = (Doctors) o;
        return id.equals(doctors.id) && fio.equals(doctors.fio) && specialization.equals(doctors.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fio, specialization);
    }
}
