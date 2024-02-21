package com.app.dto;

import java.time.LocalDate;

import com.app.entities.Role;
import com.app.entities.ServicePlan;

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
public class ServicingDTO {

	private ServicePlan plan;
	private double price;
	private LocalDate beginDate;
	private LocalDate endDate;
}
