package com.jspider.hospital_app.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Prescription {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int prescription_id;
	@UpdateTimestamp
	private LocalDateTime issueDate;
	@OneToMany
	private List<Medical_items> medical_items;
}
