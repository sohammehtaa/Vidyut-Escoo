package com.app.service;

import com.app.dto.PaymentDTO;

public interface PaymentService {

	PaymentDTO addPayment(PaymentDTO dto);
	PaymentDTO getPaymentDetails(Long paymentId);
}
