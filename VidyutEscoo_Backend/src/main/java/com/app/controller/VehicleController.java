package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.VehicleDTO;
import com.app.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin(origins = "http:/localhost:3000")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping
	public ResponseEntity<?> addNewVehicle(@RequestBody VehicleDTO dto){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.addVehicle(dto));
	}
	
	@GetMapping("/{vId}")
	public ResponseEntity<?> getVehicleDetails(@PathVariable Long vId){
		
		return ResponseEntity.ok(vehicleService.getVehicleDetails(vId));
	}
	
	@PutMapping("/{vId}")
	public ResponseEntity<?> updateVehicle(@PathVariable Long vId, @RequestBody VehicleDTO dto){
		
		return ResponseEntity.ok(vehicleService.updateVehicleDetails(vId, dto));
	}
	
	@DeleteMapping("/{vId}")
	public ResponseEntity<?> deleteVehicle(@PathVariable Long vId){
		
		return ResponseEntity.ok(vehicleService.deleteVehicle(vId));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllVehicles(){
		
		return ResponseEntity.ok(vehicleService.getAllVehicles());
	}
}
