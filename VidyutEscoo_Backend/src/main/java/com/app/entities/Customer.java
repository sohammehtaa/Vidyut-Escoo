package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer extends BaseEntity{
	
	private String name;
	private String email;
	private String password;
//	@Enumerated
//	private Role role;
	private LocalDate dob;
	private String mobile;
	private String address;
	private int zip;
	private String city;
	private String state;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Vehicle> vehicles = new ArrayList<>();
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Servicing> servicing = new ArrayList<>();
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Order> orders = new ArrayList<>();
	
	//helper methods
	
	//vehicle
	public void addVehicle(Vehicle v) {
		vehicles.add(v);
		v.setCustomer(this);
	}
	public void deleteVehicle(Vehicle v) {
		vehicles.remove(v);
		v.setCustomer(null);
	}
	
	//service
	public void addService(Servicing s) {
		servicing.add(s);
		s.setCustomer(this);
	}
	
	public void deleteService(Servicing s) {
		servicing.remove(s);
		s.setCustomer(null);
	}
	
	//order
	public void addOrder(Order o) {
		orders.add(o);
		o.setCustomer(this);
	}

	public void deleteOrder(Order o) {
		orders.remove(o);
		o.setCustomer(null);
	}
}
