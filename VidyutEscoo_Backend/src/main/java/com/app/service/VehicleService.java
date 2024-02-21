package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.VehicleDTO;

public interface VehicleService {
	
	VehicleDTO addVehicle(VehicleDTO dto);
	VehicleDTO updateVehicleDetails(Long vId, VehicleDTO dto);
	ApiResponse deleteVehicle(Long vId);
	List<VehicleDTO> getAllVehicles();
	VehicleDTO getVehicleDetails(Long vId);

}
