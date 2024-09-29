package com.jspider.hospital_app.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AppointmentRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointment_record_id;
	@CreationTimestamp
	private LocalDateTime appointmentTime;
	@UpdateTimestamp
	private LocalDateTime exitTime;
	@OneToOne
	private Prescription prescription;
}
