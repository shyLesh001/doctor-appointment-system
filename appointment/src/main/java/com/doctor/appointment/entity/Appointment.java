package com.doctor.appointment.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    private LocalDateTime appointmentDateTime;

    public Appointment() {}

    public Appointment(Doctor doctor, Patient patient, LocalDateTime appointmentDateTime) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDateTime = appointmentDateTime;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Doctor getDoctor() { return doctor; }

    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public Patient getPatient() { return patient; }

    public void setPatient(Patient patient) { this.patient = patient; }

    public LocalDateTime getAppointmentDateTime() { return appointmentDateTime; }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }
}
