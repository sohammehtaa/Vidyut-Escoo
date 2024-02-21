package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.ServicingDTO;

public interface ServicingService {
	
	ServicingDTO addService(ServicingDTO dto);
	ApiResponse deleteService(Long serviceId);
	List<ServicingDTO> getAllServicing();
	ServicingDTO getServicingDetails(Long serviceId);

}
