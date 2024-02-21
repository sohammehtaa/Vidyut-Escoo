package com.app.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Entity
@Table(name="payments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Payment extends BaseEntity{
	
	private double amount;
	private long transactionId;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime timestamp;
	@Enumerated
	private PaymentMode modeOfPayment;

}
