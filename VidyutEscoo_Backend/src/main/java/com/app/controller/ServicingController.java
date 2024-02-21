package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ServicingDTO;
import com.app.service.ServicingService;

@RestController
@RequestMapping("/servicing")
@CrossOrigin(origins = "http:/localhost:3000")
public class ServicingController {

	@Autowired
	private ServicingService servicingService;
	
	@PostMapping
	public ResponseEntity<?> addNewServicing(@RequestBody ServicingDTO service){
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(servicingService.addService(service));
	}
	
	@GetMapping("/{servicingId}")
	public ResponseEntity<?> getServicingDetails(@PathVariable Long servicingId){
		
		return ResponseEntity.ok(servicingService.getServicingDetails(servicingId));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllServicingDetails(){
		
		return ResponseEntity.ok(servicingService.getAllServicing());
	}
	
	@DeleteMapping("/{servicingId}")
	public ResponseEntity<?> deleteServicing(@PathVariable Long servicingId){
		
		return ResponseEntity.ok(servicingService.deleteService(servicingId));
	}
	
	
	
}
