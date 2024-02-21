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

import com.app.dto.OrderDTO;
import com.app.service.OrderService;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http:/localhost:3000")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public ResponseEntity<?> addNewOrder(@RequestBody OrderDTO dto){
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(orderService.addOrder(dto));	
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<?> getOrderDetails(@PathVariable Long orderId) {
		
		return ResponseEntity.ok(orderService.getOrderDetails(orderId));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllOrderDetails(){
		
		return ResponseEntity.ok(orderService.getAllOrders());
	}
	
	@DeleteMapping("/{orderId}")
	public ResponseEntity<?> deleteOrder(@PathVariable Long orderId){
		
		return ResponseEntity.ok(orderService.deleteOrder(orderId));
	}
}
