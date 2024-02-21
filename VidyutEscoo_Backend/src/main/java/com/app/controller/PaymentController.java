package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PaymentDTO;
import com.app.service.PaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "http:/localhost:3000")
public class PaymentController {

	@Autowired
	private PaymentService payService;

	@PostMapping
	public ResponseEntity<?> addNewPayment(@RequestBody PaymentDTO dto){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	
	@GetMapping("/{paymentId}")
	public ResponseEntity<?> getPaymentDetails(@PathVariable Long paymentId){
		return ResponseEntity.ok(payService.getPaymentDetails(paymentId));
	}
}
