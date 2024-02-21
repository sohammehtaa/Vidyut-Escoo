package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.CustomerDTO;

public interface CustomerService {

	CustomerDTO addCustomer(CustomerDTO dto);
	ApiResponse deleteCustomer(long CustomerId);
	CustomerDTO updateCustomer(long CustomerId, CustomerDTO dto);
	CustomerDTO getCustomerDetails(long CustomerId);
	List<CustomerDTO> getAllCustomer();
}
