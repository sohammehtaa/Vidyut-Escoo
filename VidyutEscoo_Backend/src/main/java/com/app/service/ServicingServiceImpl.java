package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.ServicingDao;
import com.app.dto.ApiResponse;
import com.app.dto.ServicingDTO;
import com.app.entities.Servicing;

@Service
@Transactional
public class ServicingServiceImpl implements ServicingService {
	
	@Autowired
	private ServicingDao serviceRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ServicingDTO addService(ServicingDTO dto) {
		Servicing serviceEntity = mapper.map(dto, Servicing.class);
		Servicing savedService = serviceRepo.save(serviceEntity);
		return mapper.map(savedService, ServicingDTO.class);
	}

	@Override
	public ApiResponse deleteService(Long serviceId) {
		Servicing service = serviceRepo.findById(serviceId)
				.orElseThrow(()->new ResourceNotFoundException("Invalid Customer Id !"));
		
		serviceRepo.delete(service);
		return new ApiResponse("Customer with id"+ service.getId()+ "deleted");
	}

	@Override
	public List<ServicingDTO> getAllServicing() {
		List<Servicing> servicingList = serviceRepo.findAll();
		return servicingList
				.stream()
				.map(s -> mapper.map(s, ServicingDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ServicingDTO getServicingDetails(Long serviceId) {
		Servicing service = serviceRepo.findById(serviceId)
				.orElseThrow(()->new ResourceNotFoundException("Invalid Customer Id !"));
		
		return mapper.map(service, ServicingDTO.class);
	}

}
