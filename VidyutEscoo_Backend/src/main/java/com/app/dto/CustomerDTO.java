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
public class CustomerDTO {

	private String name;
	private String email;
	private String password;
//	private Role role;
	private LocalDate dob;
	private long mobile;
	private String address;
	private int zip;
	private String city;
	private String state;

}
