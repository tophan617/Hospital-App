package com.jspider.hospital_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Medical_items {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medical_item_id;
	private String medical_item_name;
	private double medical_item_price;
}
