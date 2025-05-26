package com.doctor.appointment.controller;

import com.doctor.appointment.entity.Appointment;
import com.doctor.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<?> bookAppointment(@RequestBody Map<String, String> payload) {
        try {
            Long doctorId = Long.parseLong(payload.get("doctorId"));
            Long patientId = Long.parseLong(payload.get("patientId"));
            LocalDateTime appointmentDateTime = LocalDateTime.parse(payload.get("appointmentDateTime"));

            Appointment appointment = appointmentService.bookAppointment(doctorId, patientId, appointmentDateTime);
            return ResponseEntity.ok(appointment);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Optional<Appointment> optionalAppointment = appointmentService.getAppointmentById(id);
        return optionalAppointment.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelAppointment(@PathVariable Long id) {
        appointmentService.cancelAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
