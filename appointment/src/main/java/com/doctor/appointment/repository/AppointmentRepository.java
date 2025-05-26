package com.doctor.appointment.repository;

import com.doctor.appointment.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    // Check if the doctor already has an appointment at the same time
    boolean existsByDoctorIdAndAppointmentDateTime(Long doctorId, LocalDateTime dateTime);

    // Check if the patient already has an appointment at the same time
    boolean existsByPatientIdAndAppointmentDateTime(Long patientId, LocalDateTime dateTime);
}
