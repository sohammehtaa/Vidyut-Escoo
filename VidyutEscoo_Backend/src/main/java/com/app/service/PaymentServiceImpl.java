package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.PaymentDao;
import com.app.dto.PaymentDTO;
import com.app.entities.Payment;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentDao paymentRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public PaymentDTO addPayment(PaymentDTO dto) {
		
		Payment paymentEntity = mapper.map(dto, Payment.class);
		Payment savedPayment = paymentRepo.save(paymentEntity);
		return mapper.map(savedPayment, PaymentDTO.class);
	}

	@Override
	public PaymentDTO getPaymentDetails(Long paymentId) {
		
		Payment payment = paymentRepo.findById(paymentId)
				.orElseThrow(()->new ResourceNotFoundException("Invalid Payment Id !"));
		
		return mapper.map(payment, PaymentDTO.class);
	}

}
