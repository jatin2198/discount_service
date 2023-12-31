package com.discount.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="discounts")
@Getter
@Setter
public class DiscountEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int item_id;
	
	private String item_name;
	
	private String item_type;

	private double original_price;
	
	private double discnt_price;
}
