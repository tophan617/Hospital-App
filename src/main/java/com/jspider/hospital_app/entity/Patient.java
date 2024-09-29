package com.jspider.hospital_app.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patient_id;
	private String patient_name;
	private String patient_gender;
	@Max(value = 999999999)
	@Min(value = 600000000)
	private long patient_phone;
	@OneToMany
	private List<AppointmentRecord> appointmentRecord;
	@ManyToMany
	private List<Branch> branches;
}
