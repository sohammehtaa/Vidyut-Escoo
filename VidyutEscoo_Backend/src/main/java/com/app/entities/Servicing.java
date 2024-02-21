package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
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
@Table(name="services")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Servicing extends BaseEntity{

	@Enumerated
	private ServicePlan plan;
	private double price;
	private LocalDate beginDate;
	private LocalDate endDate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
}
