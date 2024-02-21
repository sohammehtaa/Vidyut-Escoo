package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.OrderDTO;

public interface OrderService {
	
	OrderDTO addOrder(OrderDTO dto);
	ApiResponse deleteOrder(Long orderId);
	List<OrderDTO> getAllOrders();
	OrderDTO getOrderDetails(Long orderId);

}
