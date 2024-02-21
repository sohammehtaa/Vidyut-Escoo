package com.app.dto;

import java.time.LocalDateTime;

import com.app.entities.PaymentMode;

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
public class PaymentDTO {

	private double amount;
	private long transactionId;
	private LocalDateTime timestamp;
	private PaymentMode modeOfPayment;
}
