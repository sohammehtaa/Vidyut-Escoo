package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.CustomerDao;
import com.app.dto.ApiResponse;
import com.app.dto.CustomerDTO;
import com.app.entities.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao custRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public CustomerDTO addCustomer(CustomerDTO dto) {
		
		Customer custEntity = mapper.map(dto, Customer.class);
		Customer savedCust = custRepo.save(custEntity);
		return mapper.map(savedCust, CustomerDTO.class);
	}

	@Override
	public ApiResponse deleteCustomer(long CustomerId) {
		
		Customer cust = custRepo.findById(CustomerId)
				.orElseThrow(()->new ResourceNotFoundException("Invalid Customer Id !"));
		
		custRepo.delete(cust);
		return new ApiResponse("Customer with id"+ cust.getId()+ "deleted");

	}

	@Override
	public CustomerDTO updateCustomer(long CustomerId, CustomerDTO dto) {
		
		Customer cust = custRepo.findById(CustomerId)
				.orElseThrow(()->new ResourceNotFoundException("Invalid Customer Id !"));
		
		mapper.map(dto, cust);
		
		return dto;
	}

	@Override
	public CustomerDTO getCustomerDetails(long CustomerId) {
		
		Customer cust = custRepo.findById(CustomerId)
				.orElseThrow(()->new ResourceNotFoundException("Invalid Customer Id !"));
		
		return mapper.map(cust, CustomerDTO.class);
	}

	@Override
	public List<CustomerDTO> getAllCustomer() {
		
		List<Customer> custList = custRepo.findAll();
		return custList
				.stream()
				.map(c -> mapper.map(c, CustomerDTO.class))
				.collect(Collectors.toList());
	}

}
