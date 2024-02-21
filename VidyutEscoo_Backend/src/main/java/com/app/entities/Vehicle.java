package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="vehicles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Vehicle extends BaseEntity{
	
	private String model;
	private double speed;
	private double rangee;
	private double power;
	private double chargingTime;
	private int batteryWarranty;
	private double price;
	private int manufacturingYear;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;

}
