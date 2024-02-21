package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.app.dto.CustomerDTO;
import com.app.service.CustomerService;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "http:/localhost:3000")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public ResponseEntity<?> getCustomerDetails(){
		
		return ResponseEntity.ok(customerService.getAllCustomer());
	}
	
	@PostMapping
	public ResponseEntity<?> addNewCustomer(@RequestBody CustomerDTO dto){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.addCustomer(dto));
	}
	
	@GetMapping(value="/{custId}")
	public ResponseEntity<?> getCustomerDetailsById(@PathVariable Long custId){
		
		return ResponseEntity.ok(customerService.getCustomerDetails(custId));
	}
	
	@DeleteMapping("/{custId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable Long custId){
		
		return ResponseEntity.ok(customerService.deleteCustomer(custId));
	}
	
	@PutMapping("/{custId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable Long custId, @RequestBody CustomerDTO dto){
		
		return ResponseEntity.ok(customerService.updateCustomer(custId, dto));
	}

}
