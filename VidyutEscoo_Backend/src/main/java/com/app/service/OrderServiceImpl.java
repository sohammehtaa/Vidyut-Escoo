package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.OrderDao;
import com.app.dto.ApiResponse;
import com.app.dto.OrderDTO;
import com.app.entities.Order;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public OrderDTO addOrder(OrderDTO dto) {
		
		Order orderEntity = mapper.map(dto, Order.class);
		Order savedOrder = orderRepo.save(orderEntity);
		return mapper.map(savedOrder, OrderDTO.class);
	}

	@Override
	public ApiResponse deleteOrder(Long orderId) {
		
		Order order = orderRepo.findById(orderId)
				.orElseThrow(()->new ResourceNotFoundException("Invalid Order Id !"));
		
		orderRepo.delete(order);
		return new ApiResponse("Order with id"+ order.getId() + "deleted");

}
	@Override
	public List<OrderDTO> getAllOrders() {
		
		List<Order> orderList = orderRepo.findAll();
		return orderList
				.stream()
				.map(o -> mapper.map(o, OrderDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public OrderDTO getOrderDetails(Long orderId) {
		
		Order order = orderRepo.findById(orderId)
				.orElseThrow(()->new ResourceNotFoundException("Invalid Order Id !"));
		
		return mapper.map(order, OrderDTO.class);

	}

}
