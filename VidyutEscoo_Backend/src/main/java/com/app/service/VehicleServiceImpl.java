package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.VehicleDao;
import com.app.dto.ApiResponse;
import com.app.dto.VehicleDTO;
import com.app.entities.Customer;
import com.app.entities.Vehicle;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	private VehicleDao vehicleRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public VehicleDTO addVehicle(VehicleDTO dto) {
		
		Vehicle vehicleEntity = mapper.map(dto,Vehicle.class);
		Vehicle savedVehicle = vehicleRepo.save(vehicleEntity);
		return mapper.map(savedVehicle, VehicleDTO.class);
	}

	@Override
	public VehicleDTO updateVehicleDetails(Long vId, VehicleDTO dto) {
		
		Vehicle vehicle = vehicleRepo.findById(vId)
				.orElseThrow(()->new ResourceNotFoundException("Invalid Customer Id !"));
		
		mapper.map(dto, vehicle);
		
		return dto;
	}

	@Override
	public ApiResponse deleteVehicle(Long vId) {
		Vehicle vehicle = vehicleRepo.findById(vId)
				.orElseThrow(()->new ResourceNotFoundException("Invalid Customer Id !"));
		
		vehicleRepo.delete(vehicle);
		return new ApiResponse("Customer with id"+ vehicle.getId()+ "deleted");
		
	}

	@Override
	public List<VehicleDTO> getAllVehicles() {
		List<Vehicle> vehicleList = vehicleRepo.findAll();
		return vehicleList
				.stream()
				.map(c -> mapper.map(c, VehicleDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public VehicleDTO getVehicleDetails(Long vId) {
		
		Vehicle v = vehicleRepo.findById(vId)
				.orElseThrow(()->new ResourceNotFoundException("Invalid Customer Id !"));
		
		return mapper.map(v, VehicleDTO.class);
		
	}

}
