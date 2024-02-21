package com.app.dto;

import java.time.LocalDate;

import com.app.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

	private String model;
	private double speed;
	private double rangee;
	private double power;
	private double chargingTime;
	private int batteryWarranty;
	private double price;
	private int manufacturingYear;
}
