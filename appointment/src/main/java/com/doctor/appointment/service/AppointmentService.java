package com.doctor.appointment.service;

import com.doctor.appointment.entity.Appointment;
import com.doctor.appointment.entity.Doctor;
import com.doctor.appointment.entity.Patient;
import com.doctor.appointment.repository.AppointmentRepository;
import com.doctor.appointment.repository.DoctorRepository;
import com.doctor.appointment.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    public Appointment bookAppointment(Long doctorId, Long patientId, LocalDateTime appointmentDateTime) {
        // Check for double booking
        if (appointmentRepository.existsByDoctorIdAndAppointmentDateTime(doctorId, appointmentDateTime)) {
            throw new RuntimeException("Doctor already has an appointment at this time.");
        }

        if (appointmentRepository.existsByPatientIdAndAppointmentDateTime(patientId, appointmentDateTime)) {
            throw new RuntimeException("Patient already has an appointment at this time.");
        }

        Optional<Doctor> doctorOpt = doctorRepository.findById(doctorId);
        Optional<Patient> patientOpt = patientRepository.findById(patientId);

        if (doctorOpt.isPresent() && patientOpt.isPresent()) {
            Appointment appointment = new Appointment(doctorOpt.get(), patientOpt.get(), appointmentDateTime);
            return appointmentRepository.save(appointment);
        } else {
            throw new RuntimeException("Doctor or Patient not found.");
        }
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public void cancelAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
